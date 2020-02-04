package main.java.com.algorithms.practice.codeforces;

import java.util.HashSet;
import java.util.Set;

public final class RemoveOneElement {
    private static int solution(int[] A){
        Set<Integer> set = new HashSet<>();
        Set<Integer> starts = new HashSet<>();
        starts.add(0);
        for(int i = 1; i < A.length; i++){
            if(A[i] <= A[i - 1]){
                set.add(i);
            }
            if(set.contains(i - 1)){
                starts.add(i);
            }
        }
        if(set.size() <= 1){
            return A.length - set.size();
        }
        for(int item: set){
            System.out.println(A[item] + " " + item);
        }
        System.out.println("\n");
        for(int item: starts){
            System.out.println(A[item] + " " + item);
        }
        return 1;
    }
    public static void main(String[] args) {
        solution(new int[]{1, 0, 2, 3, 1, 4, 5, 1, 6});
        System.out.println();
        solution(new int[]{1,2,0});
        solution(new int[]{1,2,0, 5, 6, 7, 8, 9});
    }
}
