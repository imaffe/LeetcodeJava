package Medium;

import java.util.*;

public class AmzHighFreq015MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        int len = paragraph.length();
        // return a map
        int cur = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        while(cur < len) {
            while(cur< len && !isChar(cur, paragraph)) cur++;
            StringBuilder sb = new StringBuilder();
            while(cur < len && isChar(cur, paragraph)) {
                sb.append(toLowerCase(paragraph.charAt(cur)));
                cur++;
            }
            if (sb.length() != 0) {
                String str = sb.toString();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
            cur++;
        }
        int curMax = 0;
        String ans = null;
        for (String key: map.keySet()) {
            if (!set.contains(key)) {
                if(map.get(key) > curMax) {
                    curMax = map.get(key);
                    ans = key;
                }
            }
        }
        return ans;
    }

    public boolean isChar(int cur, String str) {
        return Character.isLetter(str.charAt(cur));
    }

    public char toLowerCase(char ch) {
        return Character.toLowerCase(ch);
    }
}
