package main.java.com.algorithms.practice.codeforces;

import java.io.*;

public class Tarifa {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.parseInt(in.readLine().trim());
        int carried = 0;
        int n = Integer.parseInt(in.readLine().trim());
        for(int nn = 0; nn < n; nn++){
            int spend = Integer.parseInt(in.readLine().trim());
            int availableSpend = carried + max;
            carried = availableSpend - spend;
        }
        out.write((carried + max)+"\n");
        out.flush();
    }
}
