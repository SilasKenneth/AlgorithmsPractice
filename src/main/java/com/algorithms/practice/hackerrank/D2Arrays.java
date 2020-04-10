package main.java.com.algorithms.practice.hackerrank;

public class D2Arrays {

    private static int solution(int[][] arr){

        int currentMax = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[i].length - 1; i++){
                int sum = (arr[i][j]+
                        arr[i - 1][j - 1] +
                        arr[i - 1][j] +
                        arr[i  - 1][j + 1] +
                        arr[i + 1][j - 1] +
                        arr[i + 1][j] +
                        arr[i + 1][j + 1]);
                currentMax = Math.max(currentMax, sum);
            }
        }
        return currentMax;
    }
    public static void main(String[] args) {

    }
}
