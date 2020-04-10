package main.java.com.algorithms.practice.codeforces;

public class Basics {
    private static long solution(int n){
        if(n <= 1) return 1;
        long sum = 0;
        for(int i = 1; i < n; i++){
            sum += solution(n - i);
            System.out.println(sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
