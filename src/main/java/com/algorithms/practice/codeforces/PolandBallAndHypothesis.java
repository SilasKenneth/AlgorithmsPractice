package main.java.com.algorithms.practice.codeforces;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class PolandBallAndHypothesis {

    private static boolean isPrime(int number){
        for(int i = 2; i * i <= number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
    private static int solution(int n){
        int ans = 1;
        for(int m = 1; m <= 1000; m++){
            if(!isPrime((n * m) + 1)){
                ans = m;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(in.readLine().trim());
//        out.write(solution(n)+"\n");
        int biggest = 1;
        for(int n = 1; n <= 1000; n++){
            int ans = solution(n); //
            biggest = Math.max(biggest, ans);

            out.write(biggest +"\n");
            out.flush();
        }
        out.close();
        in.close();
//        out.flush();
    }
}
