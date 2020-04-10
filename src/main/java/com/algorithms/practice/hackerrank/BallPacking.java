package main.java.com.algorithms.practice.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BallPacking {
    public static int solution(int N, int Q, int[] B, int[] C) {
        //Buckets x contains color y z times
        Map<Integer, Map<Integer, Integer>> buckets = new HashMap<>();
        int i = 0;
        for(int c: C){
            Map<Integer, Integer> item = buckets.get(B[i]);
            if(item == null){
                item = new HashMap<>();
                item.put(c, 1);
                if(Q <= 1){
//                    System.out.println("Answer found at: "+i);
                    return i;
                }
            } else{
                int currentCount;
                if(item.containsKey(c)){
                    currentCount = item.get(c)+1;
                } else{
                    currentCount=1;
                }
                if(currentCount >= Q){
//                    System.out.println("Answer found at: "+i);
                    return i;
                }
                item.put(c, currentCount);
            }
            buckets.put(B[i], item);
            i++;
        }

        System.out.println(buckets);
        return -1;
    }

    public static void main(String[] args) {
        //N = 3, Q = 2, B = [1, 2, 0, 1, 1, 0, 0, 1] and C = [0, 3, 0, 2, 0, 3, 0, 0],
//        int a = solution(3, 2, new int[]{1,2,0,1,1,0,0,1}, new int[]{0,3,0,2,0,3,0,0});
//        int b = solution(2, 2, new int[]{0,1}, new int[]{5,5});
//        int c = solution(2,2,new int[]{0, 1, 0, 1, 0, 1}, new int[]{1, 3, 0, 0, 3, 3});
        int d = solution(1,1,new int[]{0}, new int[]{0});
//        System.out.printf("%d %d %d\n", a, b, c);
        System.out.println(d);
    }
}
