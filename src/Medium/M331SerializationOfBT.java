package Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class M331SerializationOfBT {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        List<String> seq = parse(preorder);
        for (int i = 0 ; i < seq.size(); i++) {
            if (seq.get(i).equals("#")) {
                stack.push(seq.get(i));
                stack.pop();
                if (stack.empty()) {
                    if (i == seq.size() - 1)return true;
                    else return false;
                } else {
                    stack.pop();
                }

            } else {
                stack.push(seq.get(i));
            }
        }

        if (stack.empty()) return false;
        else if (stack.size() >= 2) return false;
        else if (!stack.peek().equals("#")) return false;
        else return true;
    }

    private List<String> parse(String preorder) {
        List<String> strList = Arrays.asList(preorder.split(","));
        return strList;
    }
}
