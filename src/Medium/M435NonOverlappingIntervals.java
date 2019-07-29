package Medium;

import java.util.*;

public class M435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<List<Integer>> listIntervals  = new ArrayList<>();
        for (int i = 0 ; i < intervals.length; i++) {
            List<Integer> interval = new ArrayList<>();
            interval.add(intervals[i][0]);
            interval.add(intervals[i][1]);
            listIntervals.add(interval);
        }

        Collections.sort(listIntervals, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        int [] tombStone = new int[listIntervals.size()];
        for (int i = 0 ; i < listIntervals.size(); i++) {
            if (tombStone[i] != 1) {
                int minEnd = listIntervals.get(i).get(1);
                int minEndIndex = i;
                for (int j = i + 1; j < listIntervals.size(); j++) {
                    if (listIntervals.get(j).get(0) < listIntervals.get(i).get(1)) {
                        if (listIntervals.get(j).get(1) < minEnd) {
                            minEnd = listIntervals.get(j).get(1);
                            tombStone[minEndIndex] = 1;
                            minEndIndex = j;
                        } else {
                            tombStone[j] = 1;
                        }
                    } else break;
                }
            }
        }

        int res = 0;
        for (int i = 0 ; i < listIntervals.size() ; i++) {
            if (tombStone[i] == 1) res ++;
        }
        return res;

    }
}
