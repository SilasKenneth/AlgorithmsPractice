package main.java.com.algorithms.practice.projecteuler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Euler7 {

    private static boolean isPrimeTest(long n){
        for(long i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    private static Stream<Object> sieve(){
        int n = 10000004;
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[10000005];
        for(int i = 2; i <= n; i++){
            if(!isPrime[i] && ( (long)i * i < n)){
                for(int j = i * i; j  <= n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        int nn = 2;
        while(nn <= n){
            if(!isPrime[nn]){
                primes.add(nn);
            }
            nn++;
        }
        return Arrays.stream(primes.toArray());
    }

    private static int solution(){
        Stream<Object> stream = sieve();
        Stream<Object> stream1 = sieve();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        stream.spliterator().forEachRemaining(item -> {
        try {
            writer.write(item +"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } });
        return (Integer) stream1.collect(Collectors.toList()).get(10000);

    }
    public static void main(String[] args) {
        System.out.println(solution());
    }
}
