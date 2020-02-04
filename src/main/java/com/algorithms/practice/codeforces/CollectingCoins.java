package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;

public final class CollectingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            Long total = (long)a+(long)b+(long)c+(long)n;
            Long average = total / 3;
            if((average * 3) != total){
                System.out.println("NO");
                continue;
            }
            if(Math.max(a, Math.max(b, c)) > average){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");

        }
    }
}
