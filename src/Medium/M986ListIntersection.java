package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M986ListIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        if(A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        // if any empty just return empty



        // Doesn't matter : find the one that first interval is small, start from there.
        int [] counter = new int[2];
        Map<Integer, int[][]> queues = new HashMap<>();
        queues.put(0, A);
        queues.put(1, B);

        int thiz = 0; //0 is A, 1 is B
        List<int[]> results = new ArrayList<>();
        while(true) {
            int [] currentInterval = queues.get(thiz)[counter[thiz]];
            while(counter[1- thiz] < queues.get(1 - thiz).length && queues.get(1 - thiz)[counter[1-thiz]][1] <= currentInterval[1]) {
                int [] intersec = getIntersec(currentInterval, queues.get(1 - thiz)[counter[1-thiz]]);
                if(intersec != null) results.add(intersec);
                counter[1-thiz] ++;
            }

            if(counter[1-thiz] == queues.get(1 - thiz).length)  break;

            if(queues.get(1 - thiz)[counter[1-thiz]][0] <= currentInterval[1]) {

            }
            int [] intersec = getIntersec(currentInterval, queues.get(1 - thiz)[counter[1-thiz]]);
            if(intersec != null) results.add(intersec);

            counter[thiz]++;
            thiz = 1 - thiz;
        }

        int [][] arrayRes = new int[results.size()][2];
        for(int i =  0; i < arrayRes.length; i++) {
            arrayRes[i] = results.get(i);
        }
        return arrayRes;
    }

    public int []  getIntersec(int []a ,int [] b) {

        if(a[1] < b[0] || b[1] < a[0]) return null;
        int [] res = new int[2];
        res[0] = Math.max(a[0],b[0]);
        res[1] = Math.min(a[1],b[1]);
        return res;
    }
}
