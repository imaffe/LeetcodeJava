package Hard;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        ByteDanceQuickSort sol = new ByteDanceQuickSort();


        int[] arr = {9,5,7,3,6,2,1,4,8};
        ByteDanceQuickSort.quickSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        return;
    }
}
