//package main.java.com.algorithms.practice.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Pizza {
    private static Set<Integer> solution(int max, int types, int[] dimensions){
        Set<Integer> picks = new HashSet<>();
        for(int i = types - 1; i>=0;i--){
            if(dimensions[i] <= max){
                picks.add(i);
                max -= dimensions[i];
            }
        }
        return picks;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        int types = scanner.nextInt();
        int[] dimensions = new int[types];
        for(int i = 0; i < types; i++){
            dimensions[i] = scanner.nextInt();
        }
        Set<Integer> answers = solution(max, types, dimensions);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(answers.size()+"\n");
        for(int answer: answers){
            out.write(answer+" ");
            out.flush();
        }
        out.write("\n");
        out.flush();
    }
}
