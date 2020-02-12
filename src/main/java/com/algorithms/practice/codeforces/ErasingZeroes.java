package main.java.com.algorithms.practice.codeforces;

import java.io.*;

public class ErasingZeroes {

    private static int solution(String s){
        int begin = 0;
        int end = s.length() - 1;
        while(begin != end && (begin < s.length())){
            if((s.charAt(begin) == '1') && (s.charAt(end) == '1')) {
                break;
            }
            if(s.charAt(begin) == '0'){
                begin++;
            }

            if(s.charAt(end) == '0'){
                end--;
            }
        }
        int res = 0;
        for(int i = begin; i <= end; i++){
            if(s.charAt(i) == '0'){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine().trim());

        while(T-- > 0){
            String binaryString = in.readLine();
            out.write(solution(binaryString)+"\n");
            out.flush();
        }
    }
}
