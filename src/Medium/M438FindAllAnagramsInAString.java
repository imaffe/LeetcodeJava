package Medium;

import java.util.ArrayList;
import java.util.List;

public class M438FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int [] hashP = new int[26];
        int [] hashS = new int [26];
        for (int i = 0 ; i < p.length(); i ++) {
            hashP[p.charAt(i) - 'a'] ++;
        }

        int lenP = p.length();
        int lenS = s.length();
        if (lenS < lenP) return res;

        for (int i = 0 ; i < p.length(); i ++) {
            hashS[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0 ; i <= lenS - lenP; i ++) {
            if (isSame(hashS, hashP)) {
                res.add(i);
            }
            hashS[s.charAt(i)-'a']--;
            if (i != lenS - lenP) hashS[s.charAt(i + lenP )-'a']++;
        }

        return res;
    }

    public boolean isSame(int[] a, int[] b) {
        for (int i = 0 ; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
