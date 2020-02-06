package main.java.com.algorithms.practice.projecteuler;

public class Euler3 {
    private static boolean isPrime(long number){
        boolean prime = true;
        for(long i = 2; i*i <= number; i++){
            if(number % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }
    private static long solution(long number){
        long answer = -1;
        for(long i = 1; (i * i) <= number; i++){

            if(number % i == 0){
                long partner = (number / i);
                if(isPrime(partner)){
                    answer = partner;
                    break;
                } else if(isPrime(i)){
                    answer = i;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(600851475143L));
    }
}
