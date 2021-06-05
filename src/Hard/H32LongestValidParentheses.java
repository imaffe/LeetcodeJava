package Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class H32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        List<List<Integer>> validOnes = new ArrayList<>();
        generateSeed(validOnes, s);
        boolean canExpand = true;
        boolean canConcat = true;

        while(canExpand || canConcat) {
            canExpand = expand(validOnes, s);
            canConcat = concat(validOnes, s);
        }

        int max = 0;
        for (int i = 0 ; i < validOnes.size(); i++) {
            int cur = validOnes.get(i).get(1) - validOnes.get(i).get(0);
            if (cur > max) max = cur;
        }
        return max;
    }


    public void generateSeed(List<List<Integer>> set, String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')'){
                List<Integer> seed = new ArrayList<>();
                seed.add(i);
                seed.add(i+2);
                set.add(seed);
            }
        }
    }
    public boolean expand(List<List<Integer>> set, String s) {
        boolean finalRes = false;
        for (int i = 0; i < set.size(); i++) {
            if (doExpand(set.get(i), s)) finalRes = true;
        }
        return finalRes;
    }

    public boolean doExpand(List<Integer> valid, String s) {
        int left = valid.get(0);
        int right = valid.get(1);
        boolean res = false;
        while(left > 0 && right < s.length() ) {
            if (s.charAt(left - 1) == '(' && s.charAt(right) == ')') {
                left--;
                right ++;
                res = true;
            } else {
                break;
            }
        }
        valid.set(0, left);
        valid.set(1, right);
        return res;
    }

    public boolean concat(List<List<Integer>> validOnes, String s) {
        List<List<Integer>> after = new ArrayList<>();
        boolean res = false;
        for (int i = 0 ; i  < validOnes.size(); i++) {
            List<Integer> concat = new ArrayList<>();
            concat.add(validOnes.get(i).get(0));
            concat.add(validOnes.get(i).get(1));

            while ( i + 1 < validOnes.size() && validOnes.get(i + 1).get(0) == concat.get(1)) {
                   concat.set(1, validOnes.get(i+1).get(1));
                   i++;
                   res = true;
            }
            after.add(concat);
        }
        if (res) {
            validOnes.clear();
            validOnes.addAll(after);
        }
        return res;
    }

}
