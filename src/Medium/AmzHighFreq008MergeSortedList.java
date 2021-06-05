package Medium;

public class AmzHighFreq008MergeSortedList {

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 7, 1 ,1 ,8, 5, 2, 3, 7,9,6,4,2};
        mergeSort1(test);
        System.out.println(test);
    }

    public static void mergeSort1(int[] arr) {
        int len = arr.length;
        int[] copy = new int[len];

        mergeSort1Wrapped(arr, 0, len, copy);
    }

    public static void mergeSort1Wrapped(int[] arr, int left, int right, int[] copy) {
        if (left + 1 >= right) {
            return;
        }


        int mid = left + (right - left) / 2;
        mergeSort1Wrapped(arr, left, mid, copy);
        mergeSort1Wrapped(arr, mid, right, copy);
        int leftCur = left;
        int rightCur = mid;
        int copyCur = left;
        while (leftCur < mid && rightCur < right) {
            if (arr[leftCur] > arr[rightCur]) {
                copy[copyCur] = arr[leftCur];
                copyCur++;
                leftCur++;
            } else {
                copy[copyCur] = arr[rightCur];
                copyCur++;
                rightCur++;
            }
        }

        while(leftCur < mid) {
            copy[copyCur] = arr[leftCur];
            copyCur++;
            leftCur++;
        }

        while(rightCur < right) {
            copy[copyCur] = arr[rightCur];
            copyCur++;
            rightCur++;
        }

        for(int i = left; i < right; i++) {
            arr[i] = copy[i];
        }
        return;
    }

    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }

        int[] copy = new int[arr.length];
        mergeSortWrap(arr, 0 , arr.length, copy);
    }


    public static void mergeSortWrap(int[] arr, int left, int right, int[] copy) {
        if (left + 1 == right) return;
        int mid = left + (right - left) / 2;
        mergeSortWrap(arr, left, mid,  copy);
        mergeSortWrap(arr, mid, right, copy);

        // merge
        int copyCur = left;
        int cur1 = left;
        int cur2 = mid;
        while(cur1 != mid && cur2 != right) {
            if (arr[cur1] < arr[cur2]) {
                copy[copyCur] = arr[cur1];
                copyCur++;
                cur1++;
            } else {
                copy[copyCur] = arr[cur2];
                copyCur++;
                cur2++;
            }
        }

        if (cur1 == mid) {
            while (copyCur != right) {
                copy[copyCur] = arr[cur2];
                copyCur++;
                cur2++;
            }
        } else {
            while (copyCur != right) {
                copy[copyCur] = arr[cur1];
                copyCur++;
                cur1++;
            }
        }

        // copy
        for (int i = left; i < right; i++) {
            arr[i] = copy[i];
        }
    }
}
