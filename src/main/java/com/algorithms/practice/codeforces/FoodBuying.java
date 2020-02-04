package main.java.com.algorithms.practice.codeforces;

import java.util.Scanner;
import static java.lang.System.in;
public final class FoodBuying {
    private static long solution(int money){
        int maxBuy = (money / 10) * 10;
        int discount = maxBuy / 10;
        int mon = discount + (money % 10);
        int res = maxBuy;
        while(mon >= 10){
            res += (mon/ 10) * 10;
            maxBuy = (mon / 10) * 10;
            discount = maxBuy / 10;
            mon = discount + (mon % 10) ;
        }
        return res + mon;
    }
    private static void solver(){
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        while(T-- > 0){
            int money = scanner.nextInt();
            System.out.println(solution(money));
        }
    }
    public static void main(String[] args) {
        solver();
    }
}
