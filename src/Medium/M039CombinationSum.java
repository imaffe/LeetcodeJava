package Medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class M039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Stack<Integer> stack = new Stack<>();
        return  wrappedCombinatioSum(candidates,target,candidates.length, stack);
    }

    public List<List<Integer>> wrappedCombinatioSum(int[] nums, int target, int end, Stack<Integer> sol){
        // This question is really interesting !
        // i think I d better use a backtracking method !
        List<List<Integer>> result = new ArrayList<>();

        if (target < 0 ) return result;
        if (target == 0) {
            ArrayList<Integer> oneSol= new ArrayList<>(sol);
            result.add(oneSol);
            return result;
        }
        for (int i = end - 1; i >= 0; i--) {
            sol.push(nums[i]);
            result.addAll(wrappedCombinatioSum(nums,target - nums[i],i + 1,sol));
            sol.pop();
        }
        return result;
    }
}
