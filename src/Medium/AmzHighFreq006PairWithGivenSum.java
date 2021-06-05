package Medium;

import java.net.BindException;
import java.util.*;

public class AmzHighFreq006PairWithGivenSum {
    public int[] optimal(List<Integer> nums, int target) {
        // suppose there are multiple values
        // and is less Or Equal Than
        int len = nums.size();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i  =0 ; i < len; i++) {
            int num = nums.get(i);
            if (indexMap.containsKey(num)) {
                indexMap.get(num).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                indexMap.put(num, index);
            }
        }

        Collections.sort(nums);
        int curMax = 0;
        int [] tempAns = new int[2];
        for (int i = len -1 ; i >= 0; i--) {

            int upper = nums.get(i);
            for (int j = i - 1; j >= 0; j--) {
                int lower = nums.get(j);
                int sum = upper + lower;
                if (sum == target - 30) {
                    return getAnswer( upper, lower, indexMap);
                }
                else if (sum < target - 30 && sum > curMax) {
                    curMax = sum;
                    tempAns[0] = upper;
                    tempAns[1] = lower;
                } else if (sum <= curMax) {
                    break;
                }
            }
        }

        return getAnswer(tempAns[0], tempAns[1], indexMap);
    }

    public int[] getAnswer(int a, int b, Map<Integer, List<Integer>> indexMap) {
        if (a == b) {
            List<Integer> answerList = indexMap.get(a);
            return new int[] {answerList.get(0), answerList.get(1)};
        }
        else {
            int indexA = indexMap.get(a).get(0);
            int indexB = indexMap.get(b).get(0);
            return new int[] {indexA, indexB};
        }
    }
}
