package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class AnagramCounting {

    private static BigInteger[] factorials(){
        BigInteger[] facts = new BigInteger[102];
        facts[0] = BigInteger.ONE;
        facts[1] = BigInteger.ONE;
        for(int i = 2; i < 102; i++){
            facts[i] = facts[i - 1].multiply(BigInteger.valueOf(i));
        }
        return facts;
    }
    private static BigInteger solution(String input, BigInteger []facts){
        Map<Character, Integer> cnts = new Hashtable<>();

        for(char c: input.toCharArray()){
            cnts.merge(c, 1, Integer::sum);
        }

        BigInteger maxim = facts[input.length()];
        for(Map.Entry<Character, Integer> cnt: cnts.entrySet()){
            maxim = maxim.divide(facts[cnt.getValue()]);
        }
        return maxim;
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        BigInteger[] facts = factorials();
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            BigInteger ans = solution(s, facts);
            out.write(ans.toString()+"\n");
            out.flush();
            lines.add(s);
        }
    }
}
