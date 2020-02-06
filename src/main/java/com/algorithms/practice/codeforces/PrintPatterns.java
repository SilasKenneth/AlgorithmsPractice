package main.java.com.algorithms.practice.codeforces;

public class PrintPatterns {
    public static void main(String[] args) {
        int n = 5;
        int current = n;
        int current_left = 1;
        for(int i = n; i >= 1; i--){
            for(int j = n; j >= i; j--){
                for(int i1 = n; i1 >= j; i1--){
                    System.out.print(i1+" ");
                }
                for(int i1 = j; i1 <= n; i1++){
                    System.out.print(n + " ");
                }
            }
            current--;
            current_left++;
            System.out.println();
        }
    }
}
