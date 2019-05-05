package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M398LongestKRepetitiveSubstring {
    public int longestSubstring(String s, int k) {
        return search(s,k,0,s.length() - 1);
    }
    public int search(String s, int k, int left, int right) {
        if (left > right) return 0;
        int [] count = new int[26];

        for (int i = left ; i <= right; i++) {
            char c = s.charAt(i); // assume all lower case
            count[c-'a'] ++;
        }

        Set<Character> minor = new HashSet<>();
        for (int i = 0 ; i < 26; i++) {
            if(count[i] < k && count[i] != 0) minor.add((char)('a'+i));
        }
        if (minor.isEmpty()) return right - left + 1;

        int leftBound = left - 1;
        int rightBound = left - 1;
        int max = 0;
        for (int i = left; i <= right; i++) {
            if(minor.contains(s.charAt(i))) {
                leftBound = rightBound;
                rightBound = i;
                int res = search(s, k, leftBound + 1, rightBound - 1);
                if (res > max) max = res;
            }
        }

        // search the right half
        int res = search(s,k, rightBound + 1, right);
        if (res > max) max = res;
        return max;
    }

}
