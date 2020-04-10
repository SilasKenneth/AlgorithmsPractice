package main.java.com.algorithms.practice.codechef;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinarySearch {

    private static double pow(double base, int exponent){
        if(exponent == 0){
            return 1;
        }
        if((exponent & 1) == 0){
            return pow(base * base, exponent >> 1);
        }
        return base * pow(base, exponent - 1);
    }
    private static double binarySearch(int a, long b, double low, double high){
        if(high - low <= 0.000000000010){
            return low;
        }
        double mid = ((low + high) / 2d)+1e-14;
        double power = pow(mid, a);
        if(power > (double) b){
            return binarySearch(a, b, low, mid+1e-14);
        }
        return binarySearch(a, b, mid + 0.000000000005, high+1e-14);
    }

    private static BigInteger fib(int n){
        BigInteger fibo = BigInteger.ZERO;
        BigInteger sec = BigInteger.ONE;
        int current = 2;
        while(current <= n){
            BigInteger c = fibo.add(sec);
            fibo = sec;
            sec = c;
            current++;
        }
        return sec;
    }

    private static int digitCount(int n){
        return fib(n).toString().length();
    }
    private static int fibonacci(int k, int low, int high){
        if(low >= high){
            int curr = digitCount(low - 1);
            return curr == k ? low - 1 : -1;
        }
        int mid = (low + high) >> 1;
        int digits = digitCount(mid);
        if(digits <= k){
            return fibonacci(k, mid+1, high);
        }
        return fibonacci(k, low, mid);
    }

    private static int fibonacci(int k){
        return fibonacci(k, 0, 13900);
    }

    private static double binarySearch(int a, long b){
        return binarySearch(a, b, 0d, (double)b+1e-14);
    }

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = 0;
        int max = 123;
        System.out.println(binarySearch(4, 1900));
//        System.out.println(fib(12));
//
//        while(i <= max){
//            int a = random.nextInt(Integer.MAX_VALUE);
//            int b = random.nextInt(Integer.MAX_VALUE);
//            if(b == 0) b++;
//            double answer = binarySearch(a, b);
//            out.write(answer + "^" + a + "=" + b +"\n");
//            out.flush();
//            i++;
//        }

        Pattern p = Pattern.compile("^([a-z]+[1-9][0-9]*?)[a-z]??$");
        Map<String, Set<Boolean>> scores = new HashMap<>();
        Matcher m = p.matcher("codility90a");
        System.out.println(m.toMatchResult());
        int ans = fibonacci(max);
        if(m.find()){
            if(scores.get(m.group(1)) != null){
                scores.merge(m.group(1), new HashSet<>(), new BiFunction<Set<Boolean>, Set<Boolean>, Set<Boolean>>() {
                    @Override
                    public Set<Boolean> apply(Set<Boolean> booleans, Set<Boolean> booleans2) {
                        booleans.addAll(booleans2);
                        return booleans;
                    }
                });
            }
            m.reset();
        }
        System.out.println(ans);
//        System.out.println(fib(ans));

    }
}
