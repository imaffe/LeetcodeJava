package Medium;

public class M300LongestIncreasingSequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        TailAndLength result = longestAtNSmallerThan(nums, nums.length - 1, Integer.MAX_VALUE);
        return result.length;
    }

    private TailAndLength longestAtNSmallerThan(int [] nums, int n, int largest) {
        if (n == 0) {
            if (largest > nums[0]) return new TailAndLength(nums[0], 1);
            else {
                return new TailAndLength(0, 0);
            }
        }
        if (nums[n] >= largest) return longestAtNSmallerThan(nums, n -1, largest);
        else {
            TailAndLength useLargest = longestAtNSmallerThan(nums, n - 1, largest);
            if (useLargest.tail < nums[n]) {
                return new TailAndLength(nums[n], useLargest.length + 1);
            } else {
                TailAndLength useCurrent = longestAtNSmallerThan(nums, n - 1, nums[n]);
                if (useLargest.length > useCurrent.length + 1) {
                    return useLargest;
                } else {
                    return new TailAndLength(nums[n], useCurrent.length + 1);
                }
            }

        }
    }

    private class TailAndLength{
        public int tail;
        public int length;
        public TailAndLength(int tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }

    // the result is correct, but too slow, using DP would be better


}

