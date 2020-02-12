package main.java.com.algorithms.practice.hackerrank;

public class Java1DArray {
    private static boolean solution(int[] array, int m, int i){
        if(i < 0 || array[i] == 1){
            return false;
        }

        if((i == array.length - 1) || (i + m > array.length - 1)){
            return true;
        }
        array[i] = 1;
        return solution(array, m, i + 1) || solution(array, m, i - 1) || solution(array, m, i+ m);
    }

    public static void main(String[] args) {
        boolean ans = solution(new int[]{0,0,0,0,0,1,0,0,1}, 3, 0);
        System.out.println(ans);
    }
}
