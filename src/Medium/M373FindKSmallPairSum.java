package Medium;

import java.util.ArrayList;
import java.util.List;

public class M373FindKSmallPairSum {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int baseLen, extendLen;
        if (len1 <= len2) {
            return wrapped(nums1, nums2, k);
        } else {
            return wrapped(nums1, nums2, k);
        }
    }

    private List<int[]> wrapped(int[] nums1, int[]nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] index = new int[len1];

        List<int[]> result = new ArrayList<>();
        for (int i = 0 ; i < k ; i ++) {
            int min = Integer.MAX_VALUE;
            int cur = 0;
            for (int j = 0; j < len1; j++) {
                if (index[i] < len2 && nums1[j] + nums2[index[j]] < min) {
                    min = nums1[j] + nums2[index[j]];
                    cur = j;
                }
            }

            if(min == 100000) break;
            result.add(new int[]{nums1[cur],nums2[index[cur]]});
            index[cur] ++;
        }

        return result;
    }
}
