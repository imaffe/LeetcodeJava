package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class H57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // sort the intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });
        // flatten the whole array
        int [] flatten = new int[intervals.length * 2];
        for(int i = 0; i < intervals.length; i++){
            flatten[2*i] = intervals[i][0];
            flatten[2*i+1] = intervals[i][1];
        }


        // Implement binary search
        int lower = binarySearch(flatten, newInterval[0]);
        int upper = binarySearchB(flatten, newInterval[1]);

        int start = lower / 2; //(0, start) is not merged
        int end = upper / 2; // [end, last) is not merged

        int[] afterMerge = new int[2];
        // get afterMerge
        afterMerge[0] = Math.min(intervals[start][0], newInterval[0]);
        afterMerge[1] = Math.max(intervals[end][1], newInterval[1]);
        //

        int[][] results = new int[start + intervals.length - end - 1 + 1][2];
        int cnt = 0 ;
        for(int i = 0 ; i < start; i++){
            results[cnt][0] = intervals[i][0];
            results[cnt][1] = intervals[i][1];
            cnt++;
        }

        results[cnt][0] = afterMerge[0];
        results[cnt][1] = afterMerge[1];
        cnt++;

        for(int i = end + 1; i < intervals.length; i++) {
            results[cnt][0] = intervals[i][0];
            results[cnt][1] = intervals[i][1];
            cnt++;
        }
        return results;
    }

    public int binarySearch(int[] a, int target) {
        return binarySearchWrapped(a, target, 0, a.length);
    }

    public int binarySearchWrapped(int[] a, int target, int start, int end) {
        if(start == end) return start;
        int mid = (start + end) / 2;
        if(a[mid] == target) return mid;
        else if(a[mid] < target) {
            return binarySearchWrapped(a, target, mid + 1, end);
        } else {
            if(mid == 0 || a[mid - 1] < target) return mid;
            else return binarySearchWrapped(a, target, start, mid);
        }
    }

    public int binarySearchB(int[] a, int target) {
        return binarySearchWrappedB(a, target, 0, a.length);
    }

    public int binarySearchWrappedB(int[] a, int target, int start, int end) {
        if(start == end) return start;
        int mid = (start + end) / 2;
        if(a[mid] == target) return mid;
        else if(a[mid] < target) {
            if(mid + 1 == a.length || a[mid + 1] > target) return mid;
            else return binarySearchWrappedB(a, target, mid + 1, end);
        } else {
            return binarySearchWrappedB(a, target, start, mid);
        }
    }
}
