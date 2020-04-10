package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.*;

public class Badge {

    private static int visit(int start, int[] p){
        Set<Integer> visits = new HashSet<>();
        int ans;
        while(true){
            int next = p[start];
            if(visits.contains(start)){
                ans = start;
                break;
            }
            visits.add(start);
            start = next;
        }
        return ans;
    }
    private static int[] solution(int n, int[] p){
        int[] res = new int[n];
        for(int i = 1; i <= n; i++){
            int ans = visit(i, p);
            res[i - 1] = ans;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine().trim());
        int[] p = new int[n + 1];
        p[0] = 0;
        StringTokenizer tokenizer = new StringTokenizer(in.readLine().trim());
        int i = 1;
        while (tokenizer.hasMoreTokens()){
            p[i] = Integer.parseInt(tokenizer.nextToken());
            i++;
        }
        int[] response = solution(n, p);
        for(int item: response){
            out.write(item+" ");
            out.flush();
        }
        out.write("\n");
        out.flush();
    }
}
