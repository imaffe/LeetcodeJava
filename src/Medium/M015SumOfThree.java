package Medium;

import java.lang.reflect.Array;
import java.util.*;


public class M015SumOfThree {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> exist = new HashSet<>();
        //TODO how to construct a set from a array
        for(int i = 0; i < nums.length; i++){
            // TODO , will compiler take care of the stupid question here?
            exist.add(nums[i]);
        }

        for (int i = 0 ; i < nums.length; i++) {
            int head = nums[i];
            for(int j = i + 1 ; j < nums.length; j++) {
                int second = nums[j];
                int remain = - head - second;
                // TODO : how to gracefully express the condition here ?
                if (remain == second &&  j + 1 < nums.length && nums [j + 1] == remain && remain >= second) {
                    List<Integer> temp = new ArrayList<Integer>() {};
                    temp.add(head);
                    temp.add(second);
                    temp.add(remain);
                    if (! result.contains(temp))
                        result.add(temp);
                }

                if (remain != second && exist.contains(remain) && remain > second) {
                    List<Integer> temp = new ArrayList<Integer>() {};
                    temp.add(head);
                    temp.add(second);
                    temp.add(remain);
                    if (! result.contains(temp))
                        result.add(temp);
                }
            }
        }
        return result;
    }
}
