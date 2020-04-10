package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DreamoonAndRankingCollection {
    private static int solution(int[] A, int x){
        int[] counts = new int[105];

        for(int i = 0; i < A.length; i++){
            counts[A[i]]++;
        }

        int current = 1;
        while(x > 0 && current <= 105){
            if(counts[current] == 0){
                x--;
                counts[current]++;
            }
            current++;
        }
        for(int i = 1; i < 105; i++){
            if(counts[i] == 0){
                current = i - 1;
                break;
            }
        }
        return current + x;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine().trim());
        for(int t = 0; t < T; t++){
            String two = in.readLine().trim();
            StringTokenizer tokens = new StringTokenizer(two);
            int n = Integer.parseInt(tokens.nextToken());
            int x = Integer.parseInt(tokens.nextToken());
            String array = in.readLine().trim();
            tokens = new StringTokenizer(array);
            int[] A = new int[n];
            for(int i = 0; i < n; i++){
                A[i] = Integer.parseInt(tokens.nextToken());
            }
            out.write(solution(A, x) +"\n");
            out.flush();
        }
        out.close();
        in.close();
    }
}
