package Medium;

import java.util.Stack;

public class E20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']'){
                if (stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            } else if (ch == '}'){
                if (stack.isEmpty() || stack.peek() != '{') return false;
                else stack.pop();
            } else {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            }
        }

        if (!stack.isEmpty()) return false;
        else return true;
    }
}
