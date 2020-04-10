package main.java.com.algorithms.practice.codeforces;

import java.util.*;

public final class LazyBartender {
    private static int solution(Map<Integer, Set<Integer> >  preferences){
        Set<Integer> items = new HashSet<>();
        int counts = 0;
        for(Map.Entry<?, ?> item: preferences.entrySet()){
            Set<Integer> itemm = preferences.get(item.getKey());
            boolean already = false;
            for(Integer val: itemm){
                if(items.contains(val)){
                    already = true;
                    break;
                }
            }
            if(!already){
                for(Integer val: itemm){
                    counts++;
                    items.add(val);
                }
            }

        }
        return counts;
    }

    private static Long solve(Integer ...items){
        long sum = 0L;
        for(Integer item: items){
            sum += Long.valueOf(item);
        }
        return sum;
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> entries = new HashMap<>();
//        entries.put(0, new HashSet<>(Set.of(0, 1, 3, 6)));
//        entries.put(1, new HashSet<>(Set.of(1,4,7)));
        solution(entries);
    }
}
