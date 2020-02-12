package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class NationalProject {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine().trim());
        while(T-- > 0){
            String ngb = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(ngb);
            long n = Integer.parseInt(tokenizer.nextToken());
            long g = Integer.parseInt(tokenizer.nextToken());
            long b = Integer.parseInt(tokenizer.nextToken());
            out.write(n + " " + g + " " + b + " \n");
            long required = (n + 1)/2;
            out.write((( required * b) / g - required)+"\n");
            //TODO: Find out the issue with the code
            /*
             neededGood = Math.ceil(n / 2)
             every b bad  days there are g good days
              neededGooddays
             5000
             */
            out.flush();
        }
    }
}
