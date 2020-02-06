package main.java.com.algorithms.practice.projecteuler;

public class Euler6 {
    private static long solution(long n) {
        long squares = (((n * (n + 1L)) * ((n * 2) + 1)) / 6);
        long series = (n * (n + 1)) / 2;
        series *= series;
        return Math.abs(squares - series);
    }
    public static void main(String[] args) {
        System.out.println(solution(100L));
    }
}
