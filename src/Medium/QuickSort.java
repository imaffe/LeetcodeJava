package Medium;

public class QuickSort {
    public void sort(int [] nums) {
        int len = nums.length;
        wrappedQuickSort(nums, 0 , len - 1);
    }

    public int select (int [] nums, int k) {

        // select the Kth largest using quicksort-like algorithms
        int res = wrappedQuickSelect(nums, 0, nums.length - 1, k - 1);
        return res;
    }

    private void wrappedQuickSort(int [] nums, int low, int high) {
        int len = high - low + 1;
        if (len <= 1) return ;


        // when there are two elements
        int pivot =  partition(nums, low, high);
        wrappedQuickSort(nums, low, pivot - 1);
        wrappedQuickSort(nums, pivot + 1, high);

    }

    private int partition(int []nums, int low, int high) {
        int cnt = 0;
        int pivot = nums[high];
        for (int i = low; i <= high - 1 ;i++) {
            if (nums[i] < pivot) {
                exchange(nums, low + cnt, i);
                cnt ++;
            }
        }
        exchange(nums, low + cnt, high);
        return low + cnt;
    }

    private void exchange(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }


    // quick select implementation
    private int wrappedQuickSelect(int []nums, int low, int high, int k) {


        int pivot = partition(nums, low, high);
        if (pivot == k) return nums[pivot];
        if (pivot < k) return wrappedQuickSelect(nums, pivot + 1, high, k);
        if (pivot > k) return wrappedQuickSelect(nums, low, pivot - 1, k);
        return -1;
    }
}
