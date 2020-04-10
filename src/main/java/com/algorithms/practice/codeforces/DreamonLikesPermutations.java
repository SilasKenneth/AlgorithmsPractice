package main.java.com.algorithms.practice.codeforces;

import java.util.Arrays;

public class DreamonLikesPermutations {
    private static int[] solution(int[] A){
        int[] res = new int[4];
        int[] counts = new int[200004];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            counts[A[i]]++;
            if(counts[A[i]] > 2){
                return new int[]{0};
            }
            max = Math.max(max, A[i]);
        }

        boolean stopSeen = false;
        int firstStop = max;
        int lastStop = max;
        for(int i = 1; i <= max; i++){
            if(counts[i] == 0){
                return new int[]{0};
            }
            if(counts[i] == 1){
                if(!stopSeen)
                    firstStop = i - 1;
                stopSeen = true;
            } else if(counts[i] == 2 && stopSeen){
                return new int[]{0};
            }
        }
        return new int[]{firstStop, lastStop};
    }

    public static void main(String[] args) {
        int[] ans = solution(new int[]{2 ,1 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,1 ,10 ,2});
        int[] ans2 = solution(new int[]{1 ,4 ,3 ,2,1});
        int[] ans3 = solution(new int[]{2 ,4, 1, 3, 2, 1});
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans2));
        System.out.println(Arrays.toString(ans3));
    }
}
