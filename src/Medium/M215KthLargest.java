package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class M215KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0 ; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int result = 0;
        for (int i = 0 ; i < k; i++) {
            result = queue.poll();
        }
        return result;
    }
}
