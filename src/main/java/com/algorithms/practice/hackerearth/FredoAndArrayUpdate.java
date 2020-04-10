package main.java.com.algorithms.practice.hackerearth;

import java.io.*;
import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class FredoAndArrayUpdate {
    private static long solution(int[] A){
        long sum = 0;
        for(int a: A){
            sum += a;
        }
        long ans = 1;
        int items = A.length;
        int start = 1;
        while (ans <= sum) {
            ans = start * (long)items;
            start++;
        }
        return ans / items;
    }

    public static void main(String[] args) throws IOException{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());
        int[] A = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(in.readLine().trim());
        int i = 0;
        while(i < n){
            A[i] = Integer.parseInt(tokenizer.nextToken());
            i++;
        }
        long ans = solution(A);
        out.write(ans+"\n");
        BitSet set = new BitSet(10);
        set.set(2);
        int a = set.nextSetBit(0);
        out.flush();
    }
}
