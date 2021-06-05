package Medium;

public class H4MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0){
            if (n% 2 == 0) {
                return ((double) nums2[n/2 -1 ] + (double) nums2[n/2]) / 2;
            } else {
                return (nums2[n/2]);
            }
        } else if(n == 0) {
            if (m% 2 == 0) {
                return ((double) nums1[m/2 -1 ] + (double) nums1[m/2]) / 2;
            } else {
                return (nums1[m/2]);
            }
        } else {
            if( m > n) return wrapped(nums2, nums1);
            else return wrapped(nums1, nums2);
        }


    }

    public double wrapped(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean isOdd = false;
        if((m + n) % 2 == 0) isOdd = false;
        else isOdd = true;

        if(isOdd) {
            for(int i = 0 ; i <= m; i ++) {
                int j = (m + n - 1) / 2 - i;
                if( i == 0) {
                    if(nums2[j - 1] <= nums1[i]) {
                        return Math.min(nums1[i], nums2[j]);
                    }  else {
                        continue;
                    }
                } else if(i == m) {
                    if(nums1[i-1] <= nums2[j]) {
                        return nums2[j];
                    } else {
                        continue;
                    }
                } else {
                    if(nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]) {
                        return  Math.min(nums1[i], nums2[j]);
                    } else if(nums1[i-1] > nums2[j]){
                        // impossible
                    } else {
                        continue;
                    }
                }

            }
        } else if (m == n) {
            for(int i = 0 ; i <= m; i ++) {
                int j = m  - i;
                if(i == 0) {
                    if(nums2[j-1] <= nums1[i]) return ((double) nums2[j-1] + (double) nums1[i]) / 2;
                } else if (i == m) {
                    if(nums1[i-1] <= nums2[j]) return ((double) nums1[i-1] + (double) nums2[j]) / 2;
                } else {
                    if(nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]) {
                        return ((double) Math.max(nums1[i-1], nums2[j-1]) + (double) Math.min(nums1[i], nums2[j])) / 2;
                    } else if(nums1[i-1] > nums2[j]){
                        // impossible
                    } else {
                        continue;
                    }
                }
            }
        }
        else {
            for(int i = 0 ; i <= m; i ++) {
                int j = (m + n) / 2 - i;
                if( i == 0) {
                    if(nums2[j - 1] <= nums1[i]) {
                        return ((double) nums2[j - 1] + (double) Math.min(nums1[i], nums2[j])) / 2;
                    }  else {
                        continue ;
                    }
                } else if(i == m) {
                    if(nums1[i-1] <= nums2[j]) {
                        return ((double) nums2[j] + (double) Math.max(nums1[i-1], nums2[j-1])) / 2;
                    } else {
                        continue;
                    }
                } else {
                    if(nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]) {
                        return ((double) Math.max(nums1[i-1], nums2[j-1]) + (double) Math.min(nums1[i], nums2[j])) / 2;
                    } else if(nums1[i-1] > nums2[j]){
                        // impossible
                    } else {
                        continue;
                    }
                }

            }
        }

        return -1;
    }
}
