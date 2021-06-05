package Hard;

import java.util.ArrayList;
import java.util.List;

public class ByteDanceHeapSort {

//    public void heapSort(int[] arr) {
//
//        buildHeap(arr);
//        int curSize = arr.length;
//        for(int i = 0 ; i < arr.length; i++) {
//            getMax(arr, curSize);
//            curSize --;
//        }
//    }
//
//    public void buildHeap(int[] arr) {
//        int last = arr.length - 1;
//        int parent = (last - 1) / 2;
//        for(int i = parent; i >= 0; i--) {
//            percolateDown(arr, i, arr.length);
//        }
//    }
//
//    public int getMax(int[] arr, int size) {
//
//        swap(arr, 0, size - 1);
//        percolateDown(arr, 0 , size - 1);
//        return arr[size - 1];
//    }
//
//    public void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//
//    public void percolateDown(int[] arr, int i, int size) {
//        int left = i * 2 + 1;
//        int right = i * 2 + 2;
//        if(left >= size) return;
//        else if(right >= size) {
//            if(arr[i] > arr[left]) return;
//            else {
//                swap(arr, i, left);
//                return;
//            }
//        } else {
//            if(arr[left] > arr[right]) {
//                if(arr[i] > arr[left]) return;
//                else {
//                    swap(arr, i, left);
//                    percolateDown(arr, left, size);
//                }
//            } else{
//                if(arr[i] > arr[right]) return;
//                else {
//                    swap(arr, i, right);
//                    percolateDown(arr, right, size);
//                }
//            }
//        }
//    }

    public void heapSort(int [] arr) {
        buildMaxHeap(arr);
        int n = arr.length;
        for(int i = 0 ; i < n ; i ++){
            getMax(arr, n - i);
        }
    }

    public void buildMaxHeap(int [] arr) {
        int last = arr.length - 1;
        int parent = (last - 1) / 2;
        int size = arr.length;
        for(int i = parent; i >= 0; i--) {
            percolateDown(arr, i, size);
        }
    }

    public int getMax(int[] arr, int size) {
        // swap with last;
        int result = arr[0];
        swap(arr, 0 , size - 1);
        percolateDown(arr, 0, size - 1);
        return result;
    }

    public void percolateDown(int[] arr, int cur, int size) {
        int left = cur * 2 + 1;
        int right = cur * 2 + 2 ;
        if(left >= size)  return;
        else if(right >= size) {
            if(arr[cur] < arr[left]) swap(arr, cur, left);
            return;
        } else{
            if(arr[left] > arr[right]) {
                if(arr[cur] < arr[left]) {
                    swap(arr, cur, left);
                    percolateDown(arr, left, size);
                } else return;
            } else {
                if(arr[cur] < arr[right]) {
                    swap(arr, cur, right);
                    percolateDown(arr, right, size);
                } else return;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



}
