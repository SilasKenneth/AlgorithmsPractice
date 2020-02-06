package main.java.com.algorithms.practice.codeforces;

import java.util.*;

public final class YetAnotherWalkingRobot {
    private static void solution(String s, int n) {
        int x = 0;
        int y = 0;
        Map<String, List<Integer>> seen = new HashMap<>();
        for(int i = 0; i < n; i++){
            String key = x+""+y;
            if(seen.get(x+""+y) != null){
                List<Integer> current = seen.get(key);
                current.add(i);
                seen.put(key, current);
            } else{
                List<Integer> current = new ArrayList<>();
                current.add(i);
                seen.put(key, current);
            }
            if(s.charAt(i) == 'U'){
                y++;
            } else if(s.charAt(i) == 'D'){
                y--;
            } else if(s.charAt(i) == 'L'){
                x--;
            } else if(s.charAt(i) == 'R'){
                x++;
            }
        }

        for(Map.Entry<String, List<Integer>> item: seen.entrySet()){
            List<Integer> items = item.getValue();
            System.out.print(item.getKey() +"---> ");
            for(Integer value: items){
                System.out.print(value+" ");
            }
            System.out.println("\n");
        }
    }
    private static void solver(){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            solution(s, n);
            System.out.println("END");
        }
    }
    public static void main(String[] args) {
        solver();
    }
}
