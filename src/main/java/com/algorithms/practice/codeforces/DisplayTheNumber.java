package main.java.com.algorithms.practice.codeforces;

import java.util.*;

public final class DisplayTheNumber {
    public static String getNeeded(int[] segments, int[] picks, int maxSegs){
        List<Integer> result = new ArrayList<>();
        int i;
        if(maxSegs > 1 && maxSegs % 2 == 1){
            maxSegs -= 3;
            result.add(7);
        }
        for(i = 0; i < segments.length; i++){
            while(maxSegs >= segments[i]){
                maxSegs -= segments[i];
                result.add(picks[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        for(Integer item: result){
            builder.append(item);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] picks = {1, 7, 4, 5, 9};
        int[] segments = {2, 3, 4, 5, 6};
        while(T-- > 0){
            int number = scanner.nextInt();
            System.out.println(getNeeded(segments, picks, number));
        }
    }
}
