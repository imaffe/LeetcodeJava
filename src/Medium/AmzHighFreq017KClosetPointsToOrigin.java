package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class AmzHighFreq017KClosetPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                int dist1 = point1[0] * point1[0] + point1[1] * point1[1];
                int dist2 = point2[0] * point2[0] + point2[1] * point2[1];
                return dist1 - dist2;
            }
        });

        int len = points.length;
        if (len == 0) return new int[1][0];
        for (int i = 0; i < len; i++) {
            heap.add(points[i]);
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] res = heap.poll();
            result[i][0] = res[0];
            result[i][1] = res[1];
        }
        return result;
    }

    int[][] points;
    public int[][] kClosest1(int[][] points, int K) {
        this.points = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    public void sort(int low, int high , int K) {
        if (low >= high) return;
        int k = ThreadLocalRandom.current().nextInt(low, high);
        int pivot = dist(k);
        int mid = partition(low, high, k);
        if(mid - low + 1>= K) sort(low, mid, K);
        else sort (mid + 1, high, K - (mid - low + 1));
    }

    public int partition(int low, int high, int k) {
        int pivot = dist(k);
        swap(k, high);
        int cnt = 0;
        for (int i = low; i < high; i++){
            if (dist(i) < pivot) {
                swap(low + cnt, i);
                cnt ++;
            }
        }
        swap(low + cnt, high);
        return low + cnt;
    }

    public int dist(int k) {
        return points[k][0] * points[k][0] + points[k][1] * points[k][1];
    }

    public void swap(int i , int j) {
        int temp[] = new int[2];
        temp[0] = points[i][0];
        temp[1] = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = temp[0];
        points[j][1] = temp[1];
    }


}