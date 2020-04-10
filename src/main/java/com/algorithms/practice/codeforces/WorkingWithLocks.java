package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class WorkingWithLocks {
    static class Number implements Comparable<Number>{
        String value;
        BigDecimal representation;
        int received;
        Number(String value, int received){
            this.value = value;
            representation = new BigDecimal(this.value);
            this.received = received;
        }
        @Override
        public int compareTo(Number o) {
            if(this.representation.compareTo(o.representation) == 0){
                return this.received - o.received;
            }
            return -(this.representation.compareTo(o.representation));
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value='" + value + '\'' +
                    ", representation=" + representation +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<Number> priorityQueue = new PriorityQueue<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine().trim());

        String[] array = new String[n];
        for(int i = 0; i < n; i++){
            String number = in.readLine();
            priorityQueue.add(new Number(number, i));
            array[i] = number;
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                BigDecimal a = new BigDecimal(o1);
                BigDecimal b = new BigDecimal(o2);
                return a.compareTo(b);
            }
        }.reversed();
        Arrays.sort(array, Comparator.nullsLast(comparator));



        for(String number: array){
            System.out.print(number+" ");
        }
        System.out.println();

        while(!priorityQueue.isEmpty()){
            Number number = priorityQueue.remove();
            out.write(number+"\n");
            out.flush();
        }
    }
}
