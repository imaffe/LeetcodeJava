package Medium;

public class M274HIndex {
    public int hIndex(int[] citations) {
        sort(citations);
        int nonH = 0;
        for (int i = 0 ; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) {
                nonH = i;
                break;
            }
        }
        return citations.length - nonH;
    }


    private void sort(int[] array) {
        quickSort(array,0 , array.length - 1);
    }
    private void quickSort(int[] array, int low, int high) {
        if (low > high) return ;

        int pivot = partition(array, low, high);
        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int cnt = 0;
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                swap(array, low + cnt, i);
                cnt ++;
            }
        }
        swap(array, low + cnt, high);
        return low + cnt;
    }

    private void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
