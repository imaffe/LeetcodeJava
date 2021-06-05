package Medium;

public class RunLeetCode {
    M698PartitionToKEqualSumSubsets sol698 = new M698PartitionToKEqualSumSubsets();




    public void runM698PartitionToKEqualSumSubsets(){
        M698PartitionToKEqualSumSubsets sol = new M698PartitionToKEqualSumSubsets();
        int[] nums = new int[] {4,3,2,3,5,2,1};
        sol.canPartitionKSubsets2(nums, 4);
    }


    public void runH76MinumimWindowSubstring(){
        H76MinumumWindowSubstring sol = new H76MinumumWindowSubstring();
        int[] nums = new int[] {4,3,2,3,5,2,1};
        sol.minWindow("ADOBECODEBANC", "ABC");
    }

    public void runH4MedianOfTwoSortedArray(){
        H4MedianOfTwoSortedArray sol = new H4MedianOfTwoSortedArray();
        int[] nums1 = new int[] {1 , 2};
        int[] nums2 = new int[] {3 , 4};
        System.out.println((double)((nums1[1]+nums2[0]) /2) );
        sol.findMedianSortedArrays(nums1, nums2);
    }

    public void runH57InsertIntervals(){
        H57InsertInterval sol = new H57InsertInterval();
        int[] nums = new int[] {1,2, 3,5,6,7,8,10,12,16};
        int[][] pairs = new int[][] {{1,2}, {3,5},{6,7},{8,10},{12,16}};
        int res1 = sol.binarySearch(nums, 4);
        int res2= sol.binarySearchB(nums, 8);
        int [][] res = sol.insert(pairs, new int[]{4,8});
    }

    public void runM954DoublePair() {
        M954DoublePair sol = new M954DoublePair();
        int[] nums = new int[] {4,-2,2,-4};
        boolean res = sol.canReorderDoubled(nums);

    }
}
