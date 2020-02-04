package main.java.com.algorithms.practice.codeforces;

public final class ArraySharpening {
    private static String solution(int[] A){
        for(int i = 0; i < A.length; i++){
            if(((A.length - A[i]) < 0) && ((A[i] - i) > 0)){
                return "Yes";
            }
        }
        return "No";
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{100 ,11 ,15 ,9 ,7 ,8}));
    }
}
