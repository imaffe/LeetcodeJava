package Medium;

public class M209MinSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        // TODO another sliding window problem
        int length = nums.length;
        int totalsum = 0;
        for (int i = 0 ; i < length; i++) {
            totalsum += nums[i];
        }

        if (totalsum < s) return 0;

        // start sliding window
        int end = 0;
        int start = 0;
        int minLength = length;
        int cursum = 0;
        while (end != length) {
            cursum += nums[end++];
            while (cursum >= s) {
                int curlength = end - start;
                if (curlength < minLength) minLength = curlength;
                cursum -= nums[start++];
            }
        }

        return minLength;
    }
}
