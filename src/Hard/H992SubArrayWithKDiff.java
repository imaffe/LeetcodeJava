package Hard;

import java.util.HashMap;
import java.util.Map;

public class H992SubArrayWithKDiff {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> state1 = new HashMap<>();
        Map<Integer, Integer> state2 = new HashMap<>();
        int upper1 = 0;
        int upper2 = 0;
        int lower = 0;
        int len = A.length;
        int res = 0;
        while(lower < len) {
            if(upper1 == len && !containsK(state1, K)) break;
            while(upper1 < len && !containsK(state1, K)) {
                // add upper 1 to state 1
                int a = A[upper1];
                state1.put(a, state1.getOrDefault(a, 0) + 1);
                upper1 ++;
            }
            upper2 = upper1;
            state2 = new HashMap(state1);
            while(upper2 < len && containsK(state2, K)) {
                // add upper2 to state 2
                int a = A[upper2];
                state2.put(a, state2.getOrDefault(a,0) + 1);
                upper2 ++;
            }

            // check if upper 1 and upper 2 are valid (really contains K distinct)
            // if upper 1 is valid, upper 2 must also be valid
            if(containsK(state1, K) && containsK(state2, K)) {
                res = res + upper2 - upper1 + 1;
            }  else if (containsK(state1, K) && containsK(state2, K + 1)) {
                res = res + upper2 - upper1;
            }
            // add to results
            deleteLower(A[lower], state1);
            lower ++;
        }
        return res;
    }

    public void deleteLower(int a, Map<Integer, Integer> state) {
        if (state.get(a) == 1){
            state.remove(a);
        } else {
            state.put(a, state.get(a) - 1);
        }
    }

    public boolean containsK(Map<Integer, Integer> state, int K) {
        return state.size() == K;
    }
}
