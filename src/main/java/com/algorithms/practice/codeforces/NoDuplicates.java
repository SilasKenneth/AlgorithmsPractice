package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NoDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine().trim());
        Set<String> strings = new HashSet<>();
        int tokens = tokenizer.countTokens();
        while(tokenizer.hasMoreTokens()){
            strings.add(tokenizer.nextToken());
        }

        String ans = tokens == strings.size() ? "yes": "no";
        out.write(ans+"\n");
        out.flush();
    }
}
