package main.java.com.algorithms.practice.codeforces;

import java.io.*;
import java.util.Arrays;

public final class StringColoringEasy {
    static class Reader {
        private BufferedReader reader;

        public Reader(){
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next(){
            StringBuilder s = new StringBuilder();
            try {
                s.append(reader.readLine());
            } catch (IOException e){
                e.printStackTrace();
            }
            return s.toString();
        }

        public int nextInt(){
            StringBuilder builder = new StringBuilder();
            int res = 0;
            try{
                String s = reader.readLine().trim();
                boolean seen = false;
                boolean negative = false;
                for(Character c: s.toCharArray()){
                    if(c == '-'){
                        if(negative) break;
                        negative = true;
                    }
                    else if(((c <= '9') && (c >= '0'))){
                        builder.append(c);
                    } else if (c ==' '){
                        break;
                    } else{
                        throw new NumberFormatException("Bad input for number");
                    }
                }
                res = Integer.parseInt(builder.toString()) * (negative ? -1 : 1);
            }catch (IOException | NumberFormatException e){
                e.printStackTrace();
            }
            return res;
        }
    }

    static class Writer{
        private BufferedWriter writer;
        public Writer(){
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public <T> void println(T s) {
            try {
                writer.write(String.valueOf(s));
                writer.newLine();
                writer.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public <T> void print(T s){
            try {
                writer.write(String.valueOf(s));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class Item implements Comparable<Item>{
        private final char letter;

        public char getLetter() {
            return letter;
        }

        public int getAssigned() {
            return assigned;
        }

        private final int assigned;
        public Item(char letter, int assigned){
            this.letter = letter;
            this.assigned = assigned;
        }

        @Override
        public int compareTo(Item o) {
            return letter - o.letter;
        }

        @Override
        public boolean equals(Object obj) {
            assert obj.getClass() == Item.class;
            return ((Item) obj).letter == letter;
        }
    }
    public static void main(String[] args) {
        Writer out = new Writer();
        Reader in = new Reader();
        int n = in.nextInt();
        String s = in.next();
        Item[] items = new Item[s.length()];
        for(int i = 0; i < items.length; i++){
            items[i] = new Item(s.charAt(i), i % 2);
        }
        Arrays.sort(items);
        for(Item item: items){
            out.print(item.assigned);
        }

    }
}
