package Hard;

import java.util.*;

public class H301MinimumIVliadParen {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> resultSet = new HashSet<>();
        tryDelete(0, s, 0, "", resultSet);
        List<String> lists = new ArrayList<>(resultSet);
        return lists;
    }

    public void tryDelete(int cur, String s, int sum, String result, Set<String> resultSet) {
        while (cur < s.length() && s.charAt(cur) != '(' && s.charAt(cur) != ')') {
            result = result.concat(Character.toString(s.charAt(cur)));
            cur ++;
        }

        if (cur == s.length()) {
            if (sum != 0) return;
            if (resultSet.isEmpty()) {
                resultSet.add(result);
            }  else {
                Iterator<String> iter = resultSet.iterator();
                String one = iter.next();
                if (result.length() > one.length()) {
                    resultSet.clear();
                    resultSet.add(result);
                } else if (result.length() == one.length()) {
                    resultSet.add(result);
                } else {

                }
            }

            return;
        }

        int trySum = sum;
        if (s.charAt(cur) == '(') trySum ++;
        else if (s.charAt(cur) == ')') trySum --;
        else ;

        if (trySum < 0) tryDelete(cur + 1, s, sum, result, resultSet);
        else {
            if (s.charAt(cur) == '(') {
                tryDelete(cur + 1, s, sum + 1, result.concat("("), resultSet);
                tryDelete(cur + 1, s, sum, result, resultSet);
            } else {
                tryDelete(cur + 1, s, sum - 1, result.concat(")"), resultSet);
                tryDelete(cur + 1, s, sum, result, resultSet);
            }
        }
    }
}
