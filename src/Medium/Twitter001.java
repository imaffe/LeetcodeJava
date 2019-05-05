package Medium;

import java.util.ArrayList;
import java.util.List;

public class Twitter001 {
    public static String decode(String encoded) {
        // Write your code here
        String reverse = new StringBuffer(encoded).reverse().toString();
        List<Character> result = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        Boolean ans = backtracking(reverse, 0, result);
        for (Character ch : result) {
            res.append(ch);
        }
        return res.toString();
    }
    public static Boolean backtracking(String target, Integer cur, List<Character> result) {
        if (cur == target.length()) return true;

        if (cur + 1 >= target.length()) return false;

        Character twoChar = convert(target.substring(cur, cur+2));
        if (twoChar != null) {
            result.add(twoChar);
            Boolean ans = backtracking(target, cur + 2, result);
            if (ans) return true;
            else {
               result.remove(result.size() - 1);
            }
        }

        // then go to three char
        if (cur + 2 >= target.length()) return false;

        Character threeChar = convert(target.substring(cur,cur+3));
        if (threeChar != null) {
            result.add(threeChar);
            Boolean ans = backtracking(target,cur + 3, result);
            if (ans) return true;

        }
        return false;


    }
    public static Character convert(String number) {
        int num = Integer.valueOf(number);
        if (num == 32 || (num >= 65 && num <= 90) || (num >= 97 && num <= 122))
            return (char) num;
        else
            return null;
    }
}
