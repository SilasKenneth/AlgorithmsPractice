package main.java.com.algorithms.practice.hackerrank;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        BitSet A = new BitSet(N);
        BitSet B = new BitSet(N);
        for(int m = 0; m < M; m++){
            String command = scanner.next();
            int bitSet = scanner.nextInt();
            int index = scanner.nextInt();
            if(bitSet == 1){
                switch (command) {
                    case "SET":
                        A.set(index);
                        break;
                    case "FLIP":
                        A.flip(index);
                        break;
                    case "AND":
                        A.and(B);
                        break;
                    case "OR":
                        A.or(B);
                        break;
                    case "XOR":
                        A.xor(B);
                        break;
                }
            } else{
                switch (command) {
                    case "SET":
                        B.set(index);
                        break;
                    case "FLIP":
                        B.flip(index);
                        break;
                    case "AND":
                        B.and(A);
                        break;
                    case "OR":
                        B.or(A);
                        break;
                    case "XOR":
                        B.xor(A);
                        break;
                }
            }
            System.out.println(A.cardinality() + " "+ B.cardinality());
        }
    }
}
