package Medium;

import java.util.Arrays;

public class M033SearchRotatedSortArray {

    public int search(int[] nums, int target) {
        return regularSearch(nums, target, 0, nums.length);
    }

    public int regularSearch(int[] nums, int target, int start, int end) {
        if (end - start < 1) return -1;
        int leftPivot = nums[start];
        int rightPivot = nums[end - 1];
        if (end - start == 1 && nums[start] != target) return -1;
        if (end - start == 1 && nums[start] == target) return start;
        int mid = (start + end) / 2;
        if (target == nums[mid]) return mid;
        if (target == rightPivot) return end - 1;
        if (target == leftPivot) return start;
        if (target > rightPivot && target < leftPivot) return -1;

        if (target > leftPivot){
            if (nums[mid] > leftPivot) {
                if (target < nums[mid]) return regularSearch(nums, target, start, mid);
                else return regularSearch(nums, target, mid + 1, end);
            } else {
                return regularSearch(nums, target, start, mid);
            }
        }

        if (target < rightPivot) {
            if (nums[mid] < rightPivot){
                if (target > nums[mid]) return regularSearch(nums, target, mid + 1, end);
                else return regularSearch(nums, target, start, mid);
            } else{
                return regularSearch(nums, target, mid + 1, end);
            }
        }



        return -1;
    }
}
