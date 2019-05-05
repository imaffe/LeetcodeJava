package Medium;

public class M034FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftBound(nums, target, 0, nums.length);
        int right = findRightBound(nums, target, 0, nums.length);
        int[] result = {left, right};
        return result;
    }

    public int findLeftBound(int[] nums, int target, int start, int end) {
        // end conditions
        if(end - start < 1) return -1;
        if(end - start == 1 && nums[start] == target) return start;
        // iterative
        int mid = (start + end) / 2;
        if (nums[mid] > target) return findLeftBound(nums, target, start, mid);
        else if (nums[mid] < target) return findLeftBound(nums, target, mid + 1, end);
        else {
            if(mid - 1 < 0 || nums[mid-1] != target) return mid;
            else return findLeftBound(nums, target, start, mid);
            // could here be some repeat situation ?
        }
    }

    public int findRightBound(int[] nums, int target, int start, int end) {
        if(end - start < 1) return -1;
        if(end - start == 1 && nums[start] == target) return start;
        // iterative
        int mid = (start + end) / 2;
        if (nums[mid] > target) return findRightBound(nums, target, start, mid);
        else if (nums[mid] < target) return findRightBound(nums, target, mid + 1, end);
        else {
            if(mid + 1 >= nums.length || nums[mid+1] != target) return mid;
            else return findRightBound(nums, target, mid+1, end);
            // could here be some repeat situation ?
        }
    }



}
