package main.java.com.algorithms.practice.hackerearth;

import java.io.*;
import java.util.StringTokenizer;

public class LittleShinoAndCommonFactors {
    private static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    private static int solution(long a, long b){
        long biggest = gcd(a, b);
        int res = 0;
        long i = 1;
        while(i * i <= biggest){
            if(biggest % i == 0){
                if(i * i != biggest){
                    res += 2;
                } else{
                    res++;
                }
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine().trim());
        long a = Long.parseLong(tokenizer.nextToken());
        long b = Long.parseLong(tokenizer.nextToken());
        int res = solution(a, b);
        out.write(res+"\n");
        out.flush();

        //1000000000000 1000000000000
    }
}
