package Medium;

import java.util.ArrayList;
import java.util.List;

public class M228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int cur = 0 ;
        List<String> result = new ArrayList<>();
        while (cur < nums.length) {
            int len = findRange(nums, cur);
            String range = composeRange(nums, cur, len);
            result.add(range);
            cur += len;
        }
        return result;
    }

    private int findRange(int[] nums, int cur) {
        if (cur > nums.length) return -1;

        int len = 1;
        for (int i = cur ; i < nums.length; i++) {
            if (i + 1 >= nums.length) return len;
            if (nums[i] + 1 == nums[i + 1]) {
                len ++;
            } else {
                return len;
            }
        }
        return len;
    }

    private String composeRange(int[] nums, int start, int len) {
        if (len == 1) return String.valueOf(nums[start]);
        else {
            return (String.valueOf(nums[start]) + "->" + String.valueOf(nums[start + len - 1]));
        }
    }
}
