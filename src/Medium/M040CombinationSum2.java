package Medium;

import java.util.*;

public class M040CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        wrappedCombinationSum(candidates,target,candidates.length, stack, result);
        return result;
    }

    public void wrappedCombinationSum(int[] nums, int target, int end, Stack<Integer> sol,List<List<Integer>> result){
        // This question is really interesting !
        // i think I d better use a backtracking method !
        if (target < 0 ) return;
        if (target == 0) {
            ArrayList<Integer> oneSol= new ArrayList<>(sol);

            if (!result.contains(oneSol)) result.add(oneSol);
            return;
        }
        for (int i = end - 1; i >= 0; i--) {
            sol.push(nums[i]);
            wrappedCombinationSum(nums,target - nums[i], i ,sol, result);
            sol.pop();
        }

    }


}
