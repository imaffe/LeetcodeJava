package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M318MaxProductOfWordLength {
    public int maxProduct(String[] words) {
        List<Integer> intWords = new ArrayList<>();
        for (int i = 0; i< words.length; i++) {
            intWords.add(wordToInt(words[i]));
        }
        int max = 0;
        for (int i = 0 ;i < intWords.size(); i ++) {
            for (int j = i + 1 ; j < intWords.size(); j++) {
                if ((intWords.get(i) & intWords.get(j)) == 0) {
                    int product = words[i].length() * words[j].length();
                    if (product > max) max = product;
                }
            }
        }
        return max;
    }

    private int wordToInt(String word) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        for (int i = 0 ; i < 26; i++) {
            char test = (char)('a' + i);
            if(set.contains(test)) {
                result += (1 << i);
            }
        }

        return result;
    }
}
