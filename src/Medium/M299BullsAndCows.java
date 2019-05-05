package Medium;

import java.util.HashMap;
import java.util.Map;

public class M299BullsAndCows {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> gmap = new HashMap<>();
        int A = 0;
        int B = 0;
        for (int i = 0 ; i < len ; i ++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) A++;
            else {
                if (!smap.containsKey(s)) {
                    smap.put(s, 1);
                } else {
                    smap.put(s, smap.get(s) + 1);
                }

                if (!gmap.containsKey(g)) {
                    gmap.put(g, 1);
                } else {
                    gmap.put(g, gmap.get(g) + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
            int sValue = entry.getValue();
            if (gmap.get(entry.getKey()) != null){
                int gValue = gmap.get(entry.getKey());
                B += Math.min(sValue, gValue);
            }

        }

        return A+"A"+B+"B";
    }
}
