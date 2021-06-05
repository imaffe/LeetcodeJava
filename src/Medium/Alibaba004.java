//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String S = sc.next();
//        String T = sc.next();
//        int [] count = new int[26];
//        for(int i = 0 ; i < S.length(); i++) {
//            count[S.charAt(i) -'a']++;
//            count[T.charAt(i) - 'a']--;
//        }
//        for(int i = 0 ; i < 26; i++) {
//            if(count[i] != 0) {
//                int res = -1;
//                System.out.println(res);
//                return;
//            }
//        }
//        int res = calculate(S, T);
//        System.out.println(res);
//    }
//
//    public static int calculate(String S, String T) {
//        int len = S.length();
//        int sPos = 0;
//        int count = 0;
//        for(int i = 0 ; i < len; i ++) {
//            char ch = T.charAt(i);
//            int res = findFirstFrom(ch, S, sPos);
//            if(res == -1) {
//                return len - count;
//            } else{
//                sPos = res + 1;
//                count++;
//            }
//        }
//        return -1;
//    }
//
//    public static int findFirstFrom(char ch, String S, int from) {
//        if(from >=S.length()) return -1;
//        for(int i = from; i < S.length(); i++) {
//            if(ch == S.charAt(i)) return i;
//        }
//        return -1;
//    }
//}