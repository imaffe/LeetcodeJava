package Medium;

import java.util.*;

public class M049GroupAna {

    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO how to define tuples ?
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int id = getId(str);
            List<String> oneSol = map.get(id);
            if (oneSol == null) {
                oneSol = new ArrayList<>();
                map.put(id, oneSol);
            }
            oneSol.add(str);
        }
        result.addAll(map.values());
        return result;

    }

    public int getId(String str) {
        int [] counter = new int[26];
        for (char ch : str.toCharArray()) {
            counter[ch - 'a'] ++;
        }
        return Arrays.hashCode(counter);
    }
}
