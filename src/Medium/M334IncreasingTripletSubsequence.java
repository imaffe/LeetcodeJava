package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int[] tri = new int[3];
        int len = 0;
        if (nums.length == 0) {
            return false;
        }

        for (int i : nums) {
            int res = Arrays.binarySearch(tri, 0, len, nums[i]);
            if(res < 0) {
                res = -(res+1);
            }
            tri[res] = nums[i];
            if (res == len) {
                len ++;
            }
            if(len == 3) return true;
        }
        return false;
    }
}
