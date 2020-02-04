package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.*;

public final class ArrayWithOddSum {
    private static String solution(Integer[] A){
        int[] cnts = new int[]{0, 0};
        for(int i = 0; i < A.length; i++){
            cnts[A[i] % 2]++;
        }
        if(cnts[1] == 0){
            return "NO";
        }
        if(cnts[0] == 0){
            if(cnts[1]%2 == 0){
                return "NO";
            }
            return "YES";
        }
        return "YES";

    }

    private static void solver() throws IOException {

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(in);
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(reader.readLine());
            Collection<Integer> array = new ArrayList<>();
            Arrays.asList(reader.readLine().trim().split(" ")).forEach(item -> {
                array.add(Integer.parseInt(item));
            });
            Integer[] numbers = new Integer[N];
            array.toArray(numbers);
            out.write(solution(numbers)+"\n");
            out.flush();
        }

    }
    public static void main(String[] args) throws IOException{
        solver();
    }
}
