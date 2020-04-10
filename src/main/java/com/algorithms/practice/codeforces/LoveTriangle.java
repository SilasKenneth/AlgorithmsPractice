package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;

public final class LoveTriangle {
    static class Person{
        private Person love;
        private int id;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] likes = new int[n + 1];
        for(int i = 0; i < n; i++){
            likes[i + 1] = scanner.nextInt();
        }
        boolean hasTriangle = false;
        for(int i = 1; i <= n; i++){
            if(i == likes[likes[likes[i]]]){
                hasTriangle = true;
                break;
            }
//            System.out.println(i+" "+likes[i] +" "+ likes[likes[i]] +" "+ likes[likes[likes[i]]]);
        }
        System.out.println(hasTriangle ? "YES" : "NO");
    }
}
