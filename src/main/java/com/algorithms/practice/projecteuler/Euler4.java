package main.java.com.algorithms.practice.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Euler4 {
    private static boolean isPalindrome(int number){
        List<Integer> digits = new ArrayList<>();
        while(number > 0){
            digits.add(number % 10);
            number /= 10;
        }
        int end = digits.size() - 1;
        int start = 0;
        while(start <= end){
            if(digits.get(start) != digits.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private static int solution(){
        int ans = 9;
        for(int i = 999; i > 99; i--){
            for(int j = 999; j > 99; j--){
                if(isPalindrome(i * j)){
                    ans = Math.max(ans, i * j);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(solution());
    }
}
