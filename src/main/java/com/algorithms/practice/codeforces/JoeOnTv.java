package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;

public final class JoeOnTv {
    private static double solution(int n){
        double res = 1.0d;
        n++;
        while(n-- > 0){
            if(n == 1){
                break;
            }
            res += Math.pow(n, -1);
        }
        return res;
    }
    private static void solver(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(23));
    }
}
