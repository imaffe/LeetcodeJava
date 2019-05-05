package Medium;

import java.util.List;

public class M139WordBreaker {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.length() >= wordDict.get(i).length()){
                if (splitBreak(s, wordDict.get(i), wordDict))
                    return true;
            }
        }
        return false;
    }
    public boolean splitBreak(String s, String pivot, List<String> wordDict) {
        int wordLen = pivot.length();
        for (int i = 0; i < s.length() - wordLen + 1; i++) {
            boolean isPivot = true;
            for (int j = 0 ;j < wordLen; j++) {
                if (pivot.charAt(j) != s.charAt(i + j)) {
                    isPivot = false;
                    break;
                }
            }

            if(isPivot) {
                boolean left = wordBreak(s.substring(0, i), wordDict);
                boolean right = wordBreak(s.substring(i + wordLen, s.length()), wordDict);
                if (left && right) return true;
            }
        }

        return false;
    }

    // the above solution exceeded the time limit;
}
