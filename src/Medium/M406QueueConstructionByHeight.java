package Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class M406QueueConstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        int nums = people.length;
        if (nums == 0) return new int[0][0];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if (ints[0] > t1[0]) return 1;
                else if (ints[0] == t1[0]) return 0;
                else return -1;
            }
        });

        for (int i = 0 ; i < nums; i++) {
            maxHeap.add(people[i]);
        }

        int holes [][] = new int[nums][2];
        for (int i = 0 ; i < nums ; i ++) {
            holes[i][0] = -1;
        }
        while(maxHeap.size() != 0) {
            int [] lowest = maxHeap.poll();
            int numTaller = lowest[1];
            int cur = 0;
            while(numTaller != 0){
                if (holes[cur][0] == -1 || holes[cur][0] == lowest[0]) {
                    numTaller--;
                }
                cur++;
            }

            while(holes[cur][0] != -1) cur++;
            holes[cur][0] = lowest[0];
            holes[cur][1] = lowest[1];
        }
        return holes;
    }
}
