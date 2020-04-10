package main.java.com.algorithms.practice.hackerrank;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LibraryTask {
    private static void printForOdd(int n, int m, BufferedWriter out) throws IOException{
        int mid = (m + 1) >> 1;
        int left = mid - 1;
        int right = mid + 1;

        int placed = 0;
        if(m == 1){
            while(placed < n){
                out.write("1\n");
                out.flush();
                placed++;
            }
        }
        if(m > 1){
            out.write(mid + "\n");
            placed++;
        }

        while(placed <= n){
            if(placed == n) break;
            if(left == 0 || right > m){
                out.write(mid+"\n");
                placed++;
                out.flush();
                if(left == 0){
                    left = mid - 1;
                }
                if(right > m){
                    right = mid + 1;
                }
            }
            if(placed < n){
                out.write(left +"\n");
                out.flush();
                placed++;
                left--;
            }
            if(placed < n){
                out.write(right+"\n");
                out.flush();
                placed++;
                right++;
            }
        }
    }
    private static void solution(int n, int m, BufferedWriter out) throws IOException{
        int placed = 0;
        int left = (m + 1) >> 1;
        int right = left + 1;
        if(m % 2 == 1){
            printForOdd(n, m, out);
            return;
        }
        while(placed < n){
            if(right > m){
                right = ((m + 1) >> 1) + 1;
            }
            if(left == 0){
                left = ((m + 1) >> 1);
            }
            out.write(left+"\n");
            left--;
            placed++;
            if(placed < n && right <= m){
                out.write(right +"\n");
                right++;
                placed++;
            }
            out.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter out = new BufferedWriter(new FileWriter("library.txt"));
        int T = Integer.parseInt(in.readLine().trim());
        while(T > 0){
            String input = in.readLine().trim();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            solution(N, M, out);
            T--;
        }
    }
}
