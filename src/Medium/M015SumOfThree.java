package Medium;

import java.lang.reflect.Array;
import java.util.*;


public class M015SumOfThree {
    public List<List<Integer>> threeSum(int[] nums) {
       int len = nums.length;
       if (len == 0) return new ArrayList<>();
       Arrays.sort(nums);
       Map<Integer, Integer> pos = new HashMap<>();
       for (int i = 0 ;i < len; i ++) {
           pos.put(nums[i], i); // has the largest index so no need to worry about
       }

       Set<List<Integer>> result = new HashSet<>();
       // what will happen if I don't sort

       for (int i = 0 ; i < len; i++) {
           for(int j = i + 1; j < len; j++) {
               int remain = 0 - nums[i] - nums[j];
               if (pos.containsKey(remain) && pos.get(remain) > j) {
                   List<Integer> res = new ArrayList<>();
                   res.add(nums[i]);
                   res.add(nums[j]);
                   res.add(remain);
                    result.add(res);
               }
           }
       }
       return new ArrayList(result);
    }

}
