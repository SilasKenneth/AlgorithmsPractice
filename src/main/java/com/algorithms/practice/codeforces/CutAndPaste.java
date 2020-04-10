package main.java.com.algorithms.practice.codeforces;

public final class CutAndPaste {
    private static int solution(String s, int x){
        int l = 0;
        StringBuilder newS = new StringBuilder();
        StringBuilder ss = new StringBuilder();
        ss.append(s, 0, l+1);
        l++;
//        newS.append(s.substring(1).repeat(Integer.parseInt(""+s.charAt(l - 1))));
        ss.append(newS);
//        System.out.println(ss);
//        System.out.println(newS);
//        System.out.println(s.charAt(0));
        while(l != x){
            StringBuilder newSS = new StringBuilder();
            StringBuilder sss = new StringBuilder();
            sss.append(ss, 0, l+1);
            l++;
//            newSS.append(ss.substring(l).repeat(Integer.parseInt(""+ss.charAt(l - 1))));
            ss = new StringBuilder();
            ss.append(sss);
            ss.append(newSS);
            System.out.println(ss);
        }
        return ss.length();
    }
    public static void main(String[] args) {
        System.out.println(solution("2323", 7));
    }
}
