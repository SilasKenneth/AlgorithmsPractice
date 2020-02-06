package main.java.com.algorithms.practice.projecteuler;

public class Euler5 {
    private static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b){
        return (a * b) / gcd(a, b);
    }

    private static long solution(){
        long ans = 2;
        for(long i = 2; i <= 20; i++){
            ans = lcm(ans, i);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(solution());
    }
}
