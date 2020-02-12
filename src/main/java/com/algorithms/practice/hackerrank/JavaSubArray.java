package main.java.com.algorithms.practice.hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JavaSubArray {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] A = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
            A[i] = array[i];
            if(i > 0){
                array[i] = array[i] + array[i - 1];
            }
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int diff = 0;
                if(j == i){
                    diff = A[i];
                }else {
                    diff = i > 0 ? array[j] - array[i - 1] : array[j];
                }
                if(diff < 0){
                    res++;
                }
            }
        }

        out.write(res +"\n");
        out.flush();
    }
}
