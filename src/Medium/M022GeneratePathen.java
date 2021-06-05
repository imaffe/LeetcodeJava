package Medium;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M022GeneratePathen {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String current = new String();
        recursiveGenerate(result, current, n,0);
        return result;
    }

    public void recursiveGenerate(List<String> result,String current, int leftCount, int rightCount ) {
        // you can use backtracking in this step as well !
        if (leftCount == 0 && rightCount == 0) {
            result.add(current);
            return;
        }
        String addLeft = current + "(";
        String addRight = current  + ")";
        if (leftCount > 0)recursiveGenerate(result, addLeft, leftCount - 1, rightCount + 1);
        if (rightCount > 0) recursiveGenerate(result, addRight, leftCount, rightCount - 1);
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        String curString = new String();
        generate(result, 0, n, 0, curString);
        return result;
    }
    public void generate(List<String> result, int signal, int limit, int cur, String curString) {
        if(cur == limit) {
            int remain = signal;
            while(signal != 0) {
                curString = curString + ")";
                signal--;
            }
            result.add(curString);
            return;
        } else {
            if (signal == 0) {
                generate(result, signal + 1, limit, cur + 1, curString + "(");
                return;
            } else {
                generate(result, signal + 1, limit, cur + 1, curString + "(");
                generate(result, signal - 1, limit, cur, curString + ")");
            }
        }
    }
}
