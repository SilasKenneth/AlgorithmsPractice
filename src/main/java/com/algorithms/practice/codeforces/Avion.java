package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;

public class Avion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean blimps = false;
        int i = 1;
        for(int test = 0; test < 5; test++){
            String string = scanner.nextLine().trim();
            if(string.contains("FBI")){
                blimps = true;
                System.out.print(i+(test < 4 ? " ": ""));
            }
            i++;
        }
        if(!blimps){
            System.out.println("HE GOT AWAY!");
        }
    }
}
