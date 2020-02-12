package main.java.com.algorithms.practice.hackerrank;

import java.util.Scanner;

public class JavaCanYouAccess {
    public static void main(String[] args) {
        Inner.Private o = new Inner().new Private();
        int num = (new Scanner(System.in)).nextInt();
        System.out.println(num + " is " + o.powerof2(num));

    }

     static class Inner {
        private class Private {
            private String s;
            public Private(){
                this.s = "Hello world";
            }
            public String powerof2(int num){
                System.out.println(this.s);
                int ones = 0;
                while(num > 0){
                    if((num % 2) == 1){
                        ones++;
                    }
                    num >>= 1;
                }
                return ones == 1 ? "a power of two" : " not a power of two";
            }
        }
    }
}
