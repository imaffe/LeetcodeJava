package Medium;

public class M075SortColors {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length;
        int cur = 0;
        while (cur < end) {
            if (nums[cur] == 0 ) {
                if (cur == start) {
                    cur ++;
                    start ++;
                } else {
                    swap(nums, start, cur);
                    start ++;
                }

            } else if (nums[cur] == 1) {
                cur ++;
            } else {
                if (cur == end - 1) {
                    cur ++;
                    end --;
                } else {
                    swap(nums, cur, end - 1);
                    end --;
                }
            }
        }
    }


    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
