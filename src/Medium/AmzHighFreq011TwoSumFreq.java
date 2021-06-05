package Medium;

import java.util.HashMap;
import java.util.Map;

public class AmzHighFreq011TwoSumFreq {
    public int numberOfPairs(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < len; i ++) {
            int number = nums[i];
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else map.put(number, 1);
        }

        int result = 0;
        for (Integer num: map.keySet()) {
            int remain = target - num;
            if (remain == num && map.get(num) > 1) result ++;
            else if (map.containsKey(remain)) result ++;
            else;
        }

        return  result;
    }
}
