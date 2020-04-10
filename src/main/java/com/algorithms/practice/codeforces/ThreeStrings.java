package main.java.com.algorithms.practice.codeforces;

import java.io.*;

public class ThreeStrings {

    private static String solution(String a, String b, String c){
        int n = a.length();
        for(int i = 0; i < n; i++){
            if(a.charAt(i) != b.charAt(i)){
                if(!(a.charAt(i)+""+b.charAt(i)).contains(c.charAt(i)+"")){
                    return "NO";
                }
            }
        }
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter out =  new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine().trim());
        for(int i = 0; i < T; i++){
            String a = in.readLine().trim();
            String b = in.readLine().trim();
            String c = in.readLine().trim();
            out.write(solution(a, b, c)+"\n");
            out.flush();
        }
    }
}
