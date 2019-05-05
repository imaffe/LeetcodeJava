package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M093RestoreIPAddr {
    public List<String> restoreIpAddresses(String s) {

        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        wrappedRestore(result, stack, s, 0);
        return result;
    }
    public void wrappedRestore(List<String> result, Stack<String> stack, String s, int cur) {
           int size = stack.size();
        if (size == 4 && cur < s.length()) return;
        if (size == 4 && cur == s.length()) {
            String res = "";
            // should generate an solution
            for (String str : stack) {
                res += (str + ".");
            }
            if (res.length() > 0) result.add(res.substring(0,res.length() - 1));
            return;
        }
        if (cur == s.length()) return;

        char first =  s.charAt(cur);
           if (first == '0') {
            stack.push("" + first);
            wrappedRestore(result, stack, s, cur + 1);
            stack.pop();
            return;
        } else if (first == '1') {
            stack.push("" + first);
            wrappedRestore(result, stack, s, cur + 1);
            stack.pop();
            if (cur + 1 < s.length()) {
                char second = s.charAt(cur + 1);
                stack.push("" + first + second);
                wrappedRestore(result, stack, s, cur + 2);
                stack.pop();
                if (cur + 2 < s.length()) {
                    char third = s.charAt(cur + 2);
                    stack.push("" + first + second + third);
                    wrappedRestore(result, stack, s, cur + 3);
                    stack.pop();
                }
            }
        } else if (first == '2') {
            stack.push("" + first);
            wrappedRestore(result, stack, s, cur + 1);
            stack.pop();
            if (cur + 1 < s.length()) {
                char second = s.charAt(cur + 1);
                if (second - '0'  < 5) {
                    stack.push("" + first + second);
                    wrappedRestore(result, stack, s, cur + 2);
                    stack.pop();
                    if (cur + 2 < s.length()) {
                        char third = s.charAt(cur + 2);
                        stack.push("" + first + second + third);
                        wrappedRestore(result, stack, s, cur + 3);
                        stack.pop();
                    }
                } else if (second - '0' == 5) {
                    stack.push("" + first + second);
                    wrappedRestore(result, stack, s, cur + 2);
                    stack.pop();
                    if (cur + 2 < s.length() && s.charAt(cur + 2) - '0' <= 5) {
                        char third = s.charAt(cur + 2);
                        stack.push("" + first + second + third);
                        wrappedRestore(result, stack, s, cur + 3);
                        stack.pop();
                    }
                } else {
                    stack.push("" + first + second);
                    wrappedRestore(result, stack, s, cur + 2);
                    stack.pop();
                }
            }
        } else {
            stack.push("" + first);
            wrappedRestore(result, stack, s, cur + 1);
            stack.pop();
            if (cur + 1 < s.length()) {
                char second = s.charAt(cur + 1);
                stack.push("" + first + second);
                wrappedRestore(result, stack, s, cur + 2);
                stack.pop();
            }
        }
    }
}
