package main.java.com.algorithms.practice.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    private static void solution(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for(int nn = 0; nn < n; nn++){
            numbers.add(scanner.nextInt());
        }

        int cases = scanner.nextInt();
        for(int casess = 0; casess < cases; casess++){
            String description = scanner.next();
            int index = scanner.nextInt();
            if(description.equalsIgnoreCase("Delete")){
                numbers.remove(index);
                continue;
            }
            int number = scanner.nextInt();
            numbers.add(index, number);
        }

        for(Integer number: numbers){
            System.out.print(number + " ");
        }
        System.out.println();

    }

    public static void main(String[] args){
        solution();
    }
}
