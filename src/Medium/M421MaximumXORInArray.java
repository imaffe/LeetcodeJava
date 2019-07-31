package Medium;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class M421MaximumXORInArray {
    public int findMaximumXOR(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        Set<Integer> set0 = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        // get the initial two set
        for (int i = 0 ; i < len; i++) {
            if (nums[i] >> 31 == 1) set1.add(nums[i]);
            else set0.add(nums[i]);
        }

        if (set0.isEmpty()) set0 = null;
        if (set1.isEmpty()) set1 = null;
        int result = findMaximumAmong(set0, set1, 32);
        return result;
    }

    public int findMaximumAmong(Set<Integer> set0, Set<Integer> set1, int currentBit) {
        // NULL Check TODO
        // if (set0 == null && set1 == null)
        if (currentBit == 0) return 0;
        Set<Integer> set00;
        Set<Integer> set01;
        Set<Integer> set10;
        Set<Integer> set11;
        // TODO How to design recursive by design interface better
        if (set0 == null && set1 == null) {
            return 0;
        } else if (set1 == null) {
            int value = 0 ;
            set00 = getSubsetBy(set0, currentBit - 1, 0);
            set01 = getSubsetBy(set0, currentBit - 1, 1);
            return value + findMaximumAmong(set00, set01, currentBit - 1);
        } else if (set0 == null) {
            int value = 0;
            set10 = getSubsetBy(set1, currentBit - 1, 0);
            set11 = getSubsetBy(set1, currentBit - 1, 1);
            return value + findMaximumAmong(set10, set11, currentBit - 1);
        } else {
            int value = (int) Math.pow(2, currentBit - 1);
            set00 = getSubsetBy(set0, currentBit - 1, 0);
            set01 = getSubsetBy(set0, currentBit - 1, 1);
            set10 = getSubsetBy(set1, currentBit - 1, 0);
            set11 = getSubsetBy(set1, currentBit - 1, 1);
            // TODO can optimiza the code here
            // TODO use return value as the if statement
            if (set00 == null && set11 == null) {
                if (set01 == null && set10 == null) {
                    return value;
                } else {
                    return value + findMaximumAmong(set01, set10, currentBit - 1);
                }
            } else if (set00 == null || set11 == null) {
                if (set01 == null && set10 == null) {
                    return value + findMaximumAmong(set00, set11, currentBit - 1);
                } else if (set01 == null || set10 == null) {
                    int from00 = findMaximumAmong(set00, set11, currentBit - 1);
                    int from01 = findMaximumAmong(set01, set10, currentBit - 1);
                    return value + (from00 > from01 ? from00 : from01);
                } else {
                    return value + findMaximumAmong(set01, set10, currentBit - 1);
                }
            } else {
                if (set01 == null || set10 == null) {
                    return value + findMaximumAmong(set00, set11, currentBit - 1);
                } else {
                    int from00 = findMaximumAmong(set00, set11, currentBit - 1);
                    int from01 = findMaximumAmong(set01, set10, currentBit - 1);
                    return value + (from00 > from01 ? from00 : from01);
                }
            }
        }
    }

    public Set<Integer> getSubsetBy(Set<Integer> set, int bitToDivideOn, int zeroOrOne) {
        // if (bitToDivideOn == 0) return null;
        if (set.isEmpty()) return null;
        Set<Integer> result = new HashSet<>();
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            int num = iter.next();
            if ((num >> (bitToDivideOn - 1)) % 2 == zeroOrOne) result.add(num);
        }
        if (result.isEmpty()) return null;
        return result;
    }
}
