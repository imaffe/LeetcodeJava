package Medium;

import java.util.Arrays;
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


    public int[][] reconstructQueue2(int[][] people) {
        // sort the people from high to low, same height from front to end
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] == a2[0]) {
                    return a1[1] - a2[1];
                } else{
                    return a1[1] - a2[1];
                }
            }
        });

        int [][] results = new int[people.length][2];

        for(int i = 0 ; i < people.length; i++) {
            seat(people[i], results);
        }

        return results;

        // then sit every one accoring to k
    }

    public void seat(int[] person, int [][] results) {
        // suppose nobody heights 0
        int order = person[1];
        int height = person[0];
        int pos = 0;
        while(order != 0) {
            if(results[pos][0] == 0 || results[pos][0] == height) {
                order--;
            }
            pos++;
        }

        while(results[pos][0] != 0) pos ++;
        results[pos][0] = person[0];
        results[pos][1] = person[1];
    }
}
