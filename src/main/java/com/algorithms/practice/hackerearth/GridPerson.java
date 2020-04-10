package main.java.com.algorithms.practice.hackerearth;

import java.io.*;
import java.util.*;

public class GridPerson {

    private static boolean pathFound = false;
    static class Cell{
        private int x;
        private int y;
        private char token;
        private List<Cell> neighbours;
        private int timeVisited;
        private Cell parent = null;
        Cell(int x, int y, char token){
            this.x = x;
            this.y = y;
            this.token = token;
            this.neighbours = new ArrayList<>();
            this.timeVisited = 0;
        }

        public char getToken() {
            return token;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setTimeVisited(int timeVisited) {
            this.timeVisited = timeVisited;
        }

        public int getTimeVisited() {
            return timeVisited;
        }

        public List<Cell> getNeighbours() {
            return neighbours;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    ", token=" + token +
                    '}';
        }

        public void setNeighbours(int rows, int columns, Cell[][] cells) {
            List<Cell> neighbours = new ArrayList<>();
            if(this.x - 1 >= 0){
                neighbours.add(cells[this.x - 1][this.y]);
            }

            if(this.x + 1 < rows){
                neighbours.add(cells[this.x + 1][this.y]);
            }

            if(this.y - 1 >= 0){
                neighbours.add(cells[this.x][this.y - 1]);
            }
            if(this.y + 1 < columns){
                neighbours.add(cells[this.x][this.y + 1]);
            }
            this.neighbours = neighbours;
        }
    }

    public static List<Cell> bfs(int x, int y, Cell[][] cells, BufferedWriter out) throws IOException{
        List<Cell> tree = new ArrayList<>();
        boolean[][] visited = new boolean[cells.length][cells[0].length];
        visited[x][y] = true;

        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(cells[x][y]);
        Cell stop = null;
        int time = 1;
        while(!queue.isEmpty()){
            Cell top = queue.remove();
            top.setTimeVisited(time++);
            tree.add(top);
            stop = top;
            if(top.getToken() == 'E'){
                pathFound = true;
                break;
            }
            for(Cell neighbour: top.getNeighbours()){
                if(!visited[neighbour.getX()][neighbour.getY()] && (neighbour.getToken() == '.' || neighbour.getToken() == 'E')){
                    queue.add(neighbour);
                    neighbour.parent = top;
                    visited[neighbour.getX()][neighbour.getY()] = true;
                }
            }
        }
        out.write(stop + "\n");
        out.flush();
        return tree;
    }

    private static String[] generateMaze(int dimension){
        String[] res = new String[dimension];
        String choices = "...#...#...#..#..#..";
        Random random = new Random();
        for(int i = 0; i < dimension; i++){
            char[] buff = new char[dimension];
            for(int j = 0; j < dimension; j++){
                buff[j] = choices.charAt(random.nextInt(choices.length() - 1));
            }
            res[i] = new String(buff);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        int dimension = 200;
        BufferedWriter out = new BufferedWriter(new FileWriter("graph.txt"));
        String[] grid = generateMaze(dimension);
//        for(String row: grid){
//            System.out.println(row);
//        }
        Cell[][] cells = new Cell[grid.length][grid[0].length()];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                cells[i][j] = new Cell(i, j, grid[i].charAt(j));
                cells[i][j].setNeighbours(grid.length, grid[i].length(), cells);
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                cells[i][j].setNeighbours(grid.length, grid[i].length(), cells);
            }
        }
        List<Cell> ans = bfs(0, 0, cells, out);
        cells[0][0].token = 'S';

//        System.out.println(ans);

//        for(Cell[] cells1: cells){
//            for(Cell cell: cells1){
//                System.out.printf("%02d ", cell.getTimeVisited());
//            }
//            System.out.print("\n");
//        }


        Cell end = cells[cells.length - (new Random().nextInt(dimension - 1) + 1)][cells[0].length - (new Random().nextInt(dimension - 1) + 1)];
        end.token = 'E';
        Cell endCopy = end;
        List<Cell> path = new ArrayList<>();
        while(end != null){
            path.add(end);
            if(end.token == 'S'){
                pathFound = true;
                break;
            }
            end = end.parent;
        }

        char[][] cellss = new char[cells.length][cells[0].length];
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                if(cells[i][j].getToken() == '#'){
                    cellss[i][j] = '.';
                    continue;
                }
                cellss[i][j] = '.';
            }
        }
//        System.out.println(path);
        cellss[endCopy.getX()][endCopy.getY()] = '√';
        for(Cell cell: path){
            if(cell.getToken() != 'E') {
                cellss[cell.getX()][cell.getY()] = '*';
            }
        }

        if(pathFound) {
            for (char[] cc : cellss) {
                for (char c : cc) {
                    out.write(c+" ");
                    out.flush();
                }
                out.write("\n");
                out.flush();
            }
        }else{
            out.write(String.format("Sorry no paths were found from %s to %s\n", cells[0][0], endCopy));
            out.flush();
        }
    }

}
