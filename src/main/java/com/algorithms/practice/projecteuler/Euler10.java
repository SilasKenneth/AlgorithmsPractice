package main.java.com.algorithms.practice.projecteuler;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Euler10 {

    private static Stream<Object> sieve(int max){
        int n = max;
        List<Long> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        for(int i = 2; i <= n; i++){
            if(!isPrime[i] && ( (long)i * i < n)){
                for(int j = i * i; j  <= n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        long nn = 3;
        primes.add(2L);
        while(nn <= n){
            if(!isPrime[(int)nn]){
                primes.add(nn);
            }
            nn += 2;
        }
        return Arrays.stream(primes.toArray());
    }

    private static String solution(){
        Stream<Object> stream = sieve(2000000);
        Stream<Object> stream1 = sieve(2000000);
        AtomicLong sum = new AtomicLong();
        final BigInteger[] numbers = {BigInteger.valueOf(0)};
        stream1.forEach(number -> {
            System.out.println(number);
            numbers[0] = numbers[0].add(BigInteger.valueOf((long)number));
            sum.addAndGet((long) number);
        });
        System.out.println(sum);
        System.out.println(numbers[0]);
        BinaryOperator<Object> operator = (o, o2) -> (long)o + (long)o2;
        Optional<Object> sums = stream.reduce(operator);
        System.out.println(sums);
        return "";
    }
    public static void main(String[] args) {
        System.out.println(solution());
    }
}
