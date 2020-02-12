package main.java.com.algorithms.practice.hackerrank;

import java.util.Comparator;
import java.util.Stack;

public class JavaStack {

    private static boolean isOpening(Character c){
        return c == '{' || c == '(' || c == '[';
    }

    private static boolean isClosing(Character c){
        return c == '}' || c == ')' || c == ']';
    }

    private static boolean matches(Character opening, Character closing){
        String pair = opening + "" + closing;
        return (pair.equals("{}") || (pair.equals("()")) || (pair.equals("[]")));
    }
    private static boolean solution(String brackets){
        Stack<Character> characterStack = new Stack<>();
        for(Character c: brackets.toCharArray()){
            if(isOpening(c)){
                characterStack.push(c);
            } else if(isClosing(c)){
                if(characterStack.size() == 0){
                    return false;
                }
                if(!matches(characterStack.pop(), c)){
                    return false;
                }
            }
        }
        return characterStack.size() == 0;
    }
    public static void main(String[] args) {
        System.out.println(solution("{((){})}"));
    }
}
