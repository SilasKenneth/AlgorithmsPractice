package main.java.com.algorithms.practice.hackerrank;

import java.io.*;
import java.util.*;

public class Frequency {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Set<Integer>> frequencies = new HashMap<>();
        Map<Integer, Stack<Integer>> items = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(List<Integer> query: queries){
            if(query.get(0) == 1){
                if(items.get(query.get(1)) == null){
                    Stack<Integer> news = new Stack<>();
                    news.add(query.get(1));
                    items.put(query.get(1), news);
                    Set<Integer> currentFrequency = frequencies.get(1);
                    if(currentFrequency == null){
                        currentFrequency = new HashSet<>();
                    }
                    currentFrequency.add(query.get(1));
                    frequencies.put(1, currentFrequency);
                } else{
                    Stack<Integer> exists = items.get(query.get(1));
                    exists.push(query.get(1));
                    Set<Integer> currentFrequency = frequencies.get(1);
                    if(currentFrequency == null){
                        currentFrequency = new HashSet<>();
                    }
                    currentFrequency.add(query.get(1));
                    frequencies.put(exists.size(), currentFrequency);
                    items.put(query.get(1), exists);
                }
            } else if(query.get(0) == 2){
                Set<Integer> current = frequencies.get(query.get(1));
                if(current == null || current.size() == 0){
                    continue;
                }
                int currentCount = items.get(query.get(1)) == null ? 0 : items.get(query.get(1)).size();
                if(currentCount == 0){
                    continue;
                }
                currentCount--;
                current.remove(query.get(1));
                Set<Integer> currentNext = frequencies.get(query.get(1));
                if(currentNext == null){
                    currentNext = new HashSet<>();
                }
                currentNext.add(query.get(1));
                frequencies.put(currentCount, currentNext);
                Stack<Integer> cur = items.get(query.get(1));
                if(cur == null){
                    cur = new Stack<>();
                }
                if(!cur.isEmpty()) {
                    cur.pop();
                }

                items.put(query.get(1), cur);

            } else{
                if(frequencies.get(query.get(1)) == null){
//                    System.out.println(0);
                    res.add(0);
                } else{
//                    System.out.println(1);
                    res.add(1);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            bufferedWriter.write(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
