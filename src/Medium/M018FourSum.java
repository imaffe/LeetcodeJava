package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        int lastValue = nums[0] - 1;
        for(int i = 0; i < n; i++){
            int tmpValue = nums[i];
            if (tmpValue == lastValue) continue;
            List<List<Integer>> tmpResult = new ArrayList<>();
            // TODO add two List together ( concatentate two list)
            // TODO get the sublist
            int [] targetNums = Arrays.copyOfRange(nums,i+1, n);
            tmpResult = threeSum(targetNums, target - tmpValue, tmpValue);
            result.addAll(tmpResult);
            lastValue = tmpValue;
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int from) {
        int n = nums.length;
        if (n < 3) {
            List<List<Integer>> empty = new ArrayList<>();
            return empty;
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            int tmpValue = nums[i];
            while( left != right){
                if(nums[left] + nums[right] + tmpValue == target) {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(from);
                    solution.add(tmpValue);
                    solution.add(nums[left]);
                    solution.add(nums[right]);
                    if(!result.contains(solution)) result.add(solution);
                    left++;
                } else if (nums[left] + nums[right] + tmpValue < target){
                    left ++;
                } else{
                    right --;
                }
            }
        }
        return result;
    }
}
