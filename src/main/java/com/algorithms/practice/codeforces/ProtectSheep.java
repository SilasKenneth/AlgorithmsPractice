package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.*;

public class ProtectSheep {
    private static int rows;
    private static int columns;
    private static boolean[][] visited = new boolean[rows][columns];
    private static boolean possible = true;

    private static void performCheck(int r, int c, char[][] grids){
        boolean wolfAround = false;
        if(r + 1 < rows){
            wolfAround = grids[r + 1][c] == 'W';
        }
        if(c + 1 < columns){
            wolfAround = grids[r][c + 1] == 'W' || wolfAround;
        }

        if(r - 1 >= 0){
            wolfAround = grids[r - 1][c] == 'W' || wolfAround;
        }
        if(c - 1 >= 0){
            wolfAround = grids[r][c - 1] == 'W' || wolfAround;
        }
        if(possible){
            possible = !((grids[r][c] == 'S') && wolfAround);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine().trim());
        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());
        char[][] grids = new char[rows][columns];
        for(int i = 0; i < rows; i++){
            String line = in.readLine().trim();
            int j = 0;
            for(char c: line.toCharArray()){
                grids[i][j] = c;
                j++;
            }
        }

        for(int i = 0; i < rows; i++){
            if(!possible) break;
            for(int j = 0; j < columns; j++){
                performCheck(i, j, grids);
                if(!possible) break;
            }
        }

        if(!possible){
            out.write("No"+"\n");
            out.flush();
        }else{
            out.write("Yes"+"\n");
            out.flush();
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(grids[i][j] == '.'){
                        grids[i][j] = 'D';
                    }
                    out.write(grids[i][j] );
                    out.flush();
                }
                System.out.println();
            }
        }
    }
}
