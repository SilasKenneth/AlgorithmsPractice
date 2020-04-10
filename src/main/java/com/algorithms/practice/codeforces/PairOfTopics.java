package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PairOfTopics {
    private static void solution(int[] A, int[] B, BufferedWriter out) throws IOException{
        int[] C = new int[A.length];
        for(int i = 0; i < A.length; i++){
            C[i] = A[i] - B[i];
        }
        Arrays.sort(C);
        out.write(Arrays.toString(C)+"\n");
        out.flush();
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(in.readLine());
//        int[] A = new int[N];
//        int[] B = new int[N];
//        String a = in.readLine().trim();
//        String b = in.readLine().trim();
//        StringTokenizer tokenizer_a = new StringTokenizer(a);
//        StringTokenizer tokenizer_b = new StringTokenizer(b);
//
//        for(int i = 0; i < N; i++){
//            A[i] = Integer.parseInt(tokenizer_a.nextToken());
//            B[i] = Integer.parseInt(tokenizer_b.nextToken());
//        }
//
//        for(int i = 0, j = N - 1; i < N && j >= 0; j--, i++){
//            System.out.println(i+" "+j);
//        }
//        StringBuilder build = new StringBuilder(Integer.toString(100));
//        solution(A, B, out);
        char num = '2';
        int val = num - '0';
        System.out.println(num - '0');
    }
}
