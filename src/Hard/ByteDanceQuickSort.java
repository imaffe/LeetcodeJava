package Hard;

import java.util.*;

public class ByteDanceQuickSort {
//    public static void quicksort(int[] arr) {
//        int n = arr.length;
//        quickSortWrap(arr, 0, n - 1);
//    }
//
//    private static void quickSortWrap(int[] arr, int low, int high) {
//        if (low >= high) return;
//
//        int pivot = partition(arr, low, high);
//        quickSortWrap(arr, low, pivot-1);
//        quickSortWrap(arr, pivot+1, high);
//    }
//
//    private static int quickSelect(int[] arr, int low, int high, int K) {
//
//
//        int pivot = partition(arr, low, high);
//        if( pivot == K -1) return arr[pivot];
//        else if(pivot < K - 1) return quickSelect(arr,pivot + 1, high, K);
//        else return quickSelect(arr, low, pivot -1, K);
//    }
//    private static int partition(int[] arr, int low, int high) {
//
//        // should choose a random one, instead we use mid value;
//        int pivot = arr[(low + high)/2];
//        swap(arr, (low + high)/2, high);
//        int cnt = 0;
//        for(int i = low ; i <= high - 1; i++) {
//            if(arr[i] < pivot) {
//                swap(arr, i, low + cnt);
//                cnt++;
//            }
//        }
//        swap(arr, low + cnt, high);
//        return low + cnt;
//    }
//
    private static void swap(int[] arr, int i ,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
   }


//    public static void quickSort(int[] arr) {
//        if(arr == null || arr.length == 0) return ;
//        quickSortWrapped(arr, 0, arr.length - 1);
//    }
//
//
//    public static void quickSortWrapped(int[] arr, int left, int right) {
//        if(left >= right) return;
//        int pivot = partition(arr, left, right);
//        quickSortWrapped(arr, left, pivot - 1);
//        quickSortWrapped(arr, pivot + 1, right);
//    }
//
//    public static int partition(int[] arr, int left, int right) {
//        int mid =  (left + right) / 2;
//        int pivotValue = arr[mid];
//        swap(arr, mid, right);
//        int cnt = 0;
//        for(int i = left; i <= right - 1; i++) {
//            if(arr[i] < pivotValue) {
//                swap(arr, left + cnt, i);
//                cnt++;
//            }
//        }
//        swap(arr, left + cnt, right);
//        return left + cnt;
//    }


    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSortWrap(arr, 0, arr.length);
    }

    public static void quickSortWrap(int[] arr, int left, int right) {

        if (left >= right) return;
        int mid = left + (right - left) + 1;
        int pivot = arr[mid];
        swap(arr, mid, right - 1);

        int cnt = 0;
        for (int i = left; i < right - 1; i++) {
            if(arr[i] < pivot) {
                swap(arr, left + cnt, i);
                cnt++;           }
        }

        swap(arr, left + cnt, right - 1);
        quickSortWrap(arr, left, left + cnt);
        quickSortWrap(arr, left + cnt + 1, right);
    }


}
