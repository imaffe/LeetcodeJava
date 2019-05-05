package Medium;

public class M324WiggleSort {
    public void wiggleSort(int[] nums) {
        sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }
    public void sort(int[] nums) {
        if (nums.length == 0) return;
        quicksort(nums, 0, nums.length -1);
    }
    private void quicksort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pivot = partition(nums, low, high);

        quicksort(nums, low, pivot - 1);
        quicksort(nums, pivot + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int cnt = 0;
        int pivot = nums[high];
        for (int i = low; i <= high - 1; i++) {
            if(nums[i] < pivot) {
                swap(nums, low + cnt, i);
                cnt ++;
            }
        }

        swap(nums, low + cnt, high);
        return low + cnt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
