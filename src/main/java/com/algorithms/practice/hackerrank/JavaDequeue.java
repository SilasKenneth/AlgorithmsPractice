package main.java.com.algorithms.practice.hackerrank;

import java.util.*;

public class JavaDequeue {
    private static int solution(){
        Set<Integer> unique = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        int[] nums = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++){
            nums[i] = scanner.nextInt();
        }
        for(int i = 0; i < N; i++){
            deque.add(nums[i]);
            unique.add(nums[i]);
            if(deque.size() == M){
                max = Math.max(max, unique.size());
                int first = deque.remove();
                if(!deque.contains(first)){
                    unique.remove(first);
                }
            }
        }
        return max;

    }
    public static void main(String[] args) {
        System.out.println(solution());
    }
}
