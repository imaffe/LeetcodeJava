package Medium;

import java.util.HashMap;
import java.util.Map;

class M954DoublePair {
    public boolean canReorderDoubled(int[] A) {


        Map<Integer, Integer> total = new HashMap<>();
        for (int i = 0 ; i < A.length; i++) {
            total.put(A[i], total.getOrDefault(A[i], 0) + 1);
        }


        boolean res = canReorder(total);
        return res;
    }

    public boolean canReorder(Map<Integer, Integer> total) {
        if (total.isEmpty()) return true;

        int test = -3 % 2;
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> oddAfterHalf = new HashMap<>();
        Map<Integer, Integer> evenAfterHalf = new HashMap<>();
        for(Integer key : total.keySet()) {
            if(key % 2 == 1 || key % 2 == -1) {
                odd.put(key, total.get(key));
            } else{
                int half = key / 2;
                if (half % 2 == 1 || half % 2 == -1) {
                    oddAfterHalf.put(half, total.get(key));
                } else {
                    evenAfterHalf.put(half, total.get(key));
                }
            }
        }

        for(Integer key : odd.keySet()) {
            if (!oddAfterHalf.containsKey(key)) {
                return false;
            } else if (odd.get(key) > oddAfterHalf.get(key)) {
                return false;
            } else {

            }
        }

        for (Integer key : oddAfterHalf.keySet()) {
            int remain = oddAfterHalf.get(key) - odd.getOrDefault(key, 0);
            if (remain > 0) evenAfterHalf.put(key, remain);
        }
        return canReorder(evenAfterHalf);
    }
}