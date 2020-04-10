package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;

public class AmazingHumanCannonBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++){
            double velocity = sc.nextDouble(), angle = sc.nextDouble(), holeX = sc.nextDouble();
            double holeY1 = sc.nextDouble(), holeY2 = sc.nextDouble();
            double t = holeX / velocity / Math.cos(Math.toRadians(angle));
            double y = velocity * t * Math.sin(Math.toRadians(angle)) - 4.905 * Math.pow(t, 2);
            if(y - holeY1 >= 1 && holeY2 - y >= 1)
                System.out.println("Safe");
            else
                System.out.println("Not Safe");
        }
    }
}