package Medium;

import java.util.Arrays;

public class M416PartitionEqualSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int half = sum / 2;
        Arrays.sort(nums);
        for (int i = (int)Math.pow(2, nums.length) - 1 ; i >=0 ; i--) {
            int cur = i;
            int sumPerBit = 0;
            int count = 0;
            while(cur != 0) {
                sumPerBit += nums[nums.length - 1 - count] * (cur % 2);
                if (sumPerBit > half) break;
                count ++;
                cur = cur >> 1;
            }
            if (sumPerBit == half) return true;
        }
        return false;
    }


}
