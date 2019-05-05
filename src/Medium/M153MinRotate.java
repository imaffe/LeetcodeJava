package Medium;

public class M153MinRotate {
    public int findMin(int[] nums) {
        return findMinWrap(nums, 0 , nums.length);
    }
    public int findMinWrap(int[] nums, int start, int end) {
        int length = end - start;
        if (length <= 1) return nums[start];

        int startValue = nums[start];
        int endValue = nums[end - 1];
        if (length == 2 && startValue > endValue) return nums[start + 1];
        if (startValue < endValue) return nums[start];
        int mid = (end + start) / 2;
        if (nums[mid] > startValue)
            return findMinWrap(nums, mid, end);
        else return findMinWrap(nums,start, mid + 1);
    }
}
