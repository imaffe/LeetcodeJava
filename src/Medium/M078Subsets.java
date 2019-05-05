package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // back tracking again
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        backtracking(result, nums, cur, stack);
        return result;
    }

    public void backtracking(List<List<Integer>> result, int [] nums, int cur, Stack<Integer> stack) {
        if (cur == nums.length) {
            List<Integer> one = new ArrayList<>(stack);
            result.add(one);
            return;
        }
        stack.push(nums[cur]);
        backtracking(result, nums, cur + 1, stack);
        stack.pop();
        backtracking(result, nums, cur + 1, stack);
    }
}
