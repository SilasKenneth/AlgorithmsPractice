package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;

public final class Quadrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int ans = 1;
        if(x < 0 && y > 0){
            ans = 2;
        } else if(x > 0 && y < 0){
            ans = 4;
        } else if(x < 0 && y < 0){
            ans = 3;
        }
        System.out.println(ans);
    }
}
