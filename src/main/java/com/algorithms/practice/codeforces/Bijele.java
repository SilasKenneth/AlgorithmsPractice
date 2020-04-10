package main.java.com.algorithms.practice.codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public final class Bijele {
    public static void main(String[] args) {
        int[] required = {1,1,2,2,2,8};
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i <= 5; i++){
            int available = scanner.nextInt();
            required[i]  -= available;
        }

        for(int i = 0; i < 6; i++){
            System.out.print(required[i]+" ");
        }
        System.out.println();
    }
}
