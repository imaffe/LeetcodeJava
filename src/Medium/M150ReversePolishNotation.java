package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M150ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            switch (str){
                case "*": calculateStack(stack, "*"); break;
                case "+": calculateStack(stack, "+"); break;
                case "-": calculateStack(stack, "-"); break;
                case "/": calculateStack(stack, "/"); break;
                default: pushToStack(stack, str); break;
            }
        }

        return stack.peek();
    }

    public void pushToStack(Stack<Integer> stack, String str) {
        int value = Integer.valueOf(str);
        stack.add(value);
    }

    public void calculateStack(Stack<Integer> stack, String oper) {
        int val2 = stack.pop();
        int val1 = stack.pop();
        switch(oper) {
            case "*": stack.add(val1 * val2); break;
            case "+": stack.add(val1 + val2); break;
            case "-": stack.add(val1 - val2); break;
            case "/": stack.add(val1 / val2); break;
        }
    }
}
