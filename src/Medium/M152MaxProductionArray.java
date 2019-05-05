package Medium;

import java.util.ArrayList;
import java.util.List;

public class M152MaxProductionArray {
    public int maxProduct(int[] nums) {
        // first split using 0
        int length = nums.length;
        List<Integer> res = new ArrayList();
        int lastZero = -1;
        for (int i = 0 ;i < length; i++) {
            if (nums[i] == 0) {
                res.add(maxProductNoZero(nums, lastZero + 1, i));
                lastZero = i;
            }
        }
        res.add(maxProductNoZero(nums, lastZero+1, length));
        if (res.size() > 1) res.add(0);
        else return res.get(0);

        int max = 0;
        for (Integer num : res) {
            if (num > max) max = num;
        }
        return max;
    }

    public int maxProductNoZero(int[] nums, int start, int end) {
        if (start >= end) return 0;
        if (end - start == 1 && nums[start] < 0) return nums[start];
        int odd = 0;
        int firstOdd = -1;
        int lastOdd = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] < 0) {
                firstOdd = i;
                break;
            }
        }
        for (int i = start; i < end; i++) {
            if (nums[i] < 0) {
                odd ++;
                lastOdd = i;
            }
        }

        if (odd % 2 == 0) {
            return product(nums, start, end);
        } else {
            return Math.max(product(nums, start, lastOdd), product(nums, firstOdd + 1, end));
        }
    }

    public int product(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int product = 1;
        for (int  i= start; i < end; i++)  {
            product *= nums[i];
        }
        return product;
    }
}
