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
}
