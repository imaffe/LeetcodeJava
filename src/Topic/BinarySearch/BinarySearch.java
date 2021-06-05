package Topic.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
    }


    // find the first element that is bigger than
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (arr[mid] == target) {
                right = mid;
            }  else if(arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (arr[left] == target) {
            return left;
        }
        if (arr[right] == target) {
            return right;
        }

        return -1;
    }

}
