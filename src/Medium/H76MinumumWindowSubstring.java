package Medium;

import java.util.HashMap;
import java.util.Map;

public class H76MinumumWindowSubstring {
    public String minWindow(String s, String t) {
        // create char count map for t
        Map<Character, Integer> target = new HashMap<>();

        for(int i = 0 ; i < t.length(); i++) {
            char ch = t.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        int upper = 0;
        int lower = 0;
        Map<Character, Integer> window = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int minLower = 0;
        int minUpper = 0;
        while(upper < s.length()) {
            while(upper < s.length() && !includeTarget(window, target)) {
                // add to the window
                char ch = s.charAt(upper);
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                upper ++;
            }
            while(lower < upper && includeTarget(window, target)) {
                // move left
                char ch = s.charAt(lower);
                window.put(ch, window.get(ch) - 1);
                lower ++;
            }

            int length = upper - lower + 1;
            if(length < minLength){
                minLength = length;
                minLower = lower - 1;
                minUpper = upper;
            }
        }
        return s.substring(minLower, minUpper);
        // int upper =0; int lower to 0;
        // move the window, if find answer, move left to just pass the answer range
        // record the length; compare
        // move the window right,


    }

    public boolean includeTarget(Map<Character, Integer> window, Map<Character, Integer> target){
        for(Character ch : target.keySet()) {
            if(window.containsKey(ch)) {
                if(window.get(ch) < target.get(ch)) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
