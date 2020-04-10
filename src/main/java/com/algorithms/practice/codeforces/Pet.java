package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Pet {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long maximum = Long.MIN_VALUE;
        int ans = 1;
        for(int i = 0; i < 5; i++){
            StringTokenizer tokenizer = new StringTokenizer(in.readLine().trim());
            long sum = 0;
            while(tokenizer.hasMoreTokens()){
                Object value = tokenizer.nextToken();
                int item = Integer.parseInt(String.valueOf(value));
                sum += item;
            }
            if(maximum < sum){
                ans = i+1;
            }
            maximum = Math.max(sum, maximum);
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(ans+" "+maximum+"\n");
        out.flush();
    }
}
