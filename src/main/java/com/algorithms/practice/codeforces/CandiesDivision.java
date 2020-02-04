package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public final class CandiesDivision {
    private static int solution(int Candies, int Kids){
        int distributed = Candies / Kids;
        int surplus = Candies % Kids;
        int distributedSurplus = Math.min(Kids / 2, surplus);
        return (distributed * Kids) + distributedSurplus;
    }
    private static void solver(){
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        while(T-- > 0){
            int Candies = scanner.nextInt();
            int Kids = scanner.nextInt();
            out.println(solution(Candies, Kids));
        }
    }
    public static void main(String[] args) {
        solver();
    }
}
