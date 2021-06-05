package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M698PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //
        if (k == 0) {
            if(nums.length != 0) return false;
            else return true;
        }
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % k != 0) return false;
        int target = sum / k;

        List<Set<Integer>> sols = getListSols(nums, target, 0);
        // sol stand for the index in the array
        boolean res = false;
        for(Set<Integer> sol : sols) {
            int newlen = nums.length - sol.size();
            int []newnums = new int[newlen];
            int cur = 0;
            for (int i = 0 ; i < nums.length; i++) {
                if (sol.contains(i)) continue;
                newnums[cur++] = nums[i];
            }
            res = canPartitionKSubsets(newnums, k - 1);
            if(res) return res;
        }
        return false;
    }

    public List<Set<Integer>> getListSols(int[] nums, int target, int cur) {
        if(target < 0) {
            return null;
        } else if (target == 0){
            Set<Integer> sol = new HashSet<>();
            List<Set<Integer>> sols = new ArrayList<>();
            sols.add(sol);
            return sols;
        } else {
            if (cur == nums.length) return null;
            List<Set<Integer>> sol = new ArrayList<>();
            for (int i = cur; i < nums.length; i++) {
                List<Set<Integer>> res = getListSols(nums, target - nums[i], i + 1);
                if(res != null) {
                    for(Set<Integer> oneOfRes : res) {
                        Set<Integer> copy = new HashSet<>(oneOfRes);
                        copy.add(i);
                        sol.add(copy);
                    }
                }
            }
            return sol;
        }
    }


    // sol2
    public boolean canPartitionKSubsets2(int[] nums, int k) {

        if (k == 0) {
            if(nums.length != 0) return false;
            else return true;
        }
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % k != 0) return false;
        int target = sum / k;

        List<Set<Integer>> sols = getListSols(nums, target, 0);

        return canCover(sols, nums);
    }


    public boolean canCover(List<Set<Integer>> sols, int [] nums) {
        Set<Integer> target = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++) {
            target.add(i);
        }
        Set<Set<Integer>> covers = new HashSet<>();
        covers.add(new HashSet<>());
        for (int i = 0 ; i < sols.size(); i++) {
            Set<Integer> sol = sols.get(i);
            Set<Set<Integer>> newCovers = new HashSet<>();
            for(Set<Integer> cover: covers) {
                if(!isOverlap(sol, cover)) {
                    Set<Integer> newCover = new HashSet<>();
                    newCover.addAll(sol);
                    newCover.addAll(cover);
                    newCovers.add(newCover);
                }
            }
            newCovers.addAll(covers);
            covers = newCovers;
            if(covers.contains(target)) return true;
        }
        return false;
    }
    public boolean isOverlap(Set<Integer> sol, Set<Integer> cover) {
        for(Integer num : sol) {
            if(cover.contains(num)) return true;
        }
        return false;
    }
}
