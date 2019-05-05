package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter002 {
    public static List<Integer> closest(String s, List<Integer> queries) {
        // Write your code here
        Map closetMap = new HashMap();
        Map indexMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!closetMap.containsKey(ch)){
                List<Integer> indexlist = new ArrayList<>();
                closetMap.put(ch, indexlist);
                indexlist.add(i);
                indexMap.put(i,0);
            } else {
                List<Integer> indexlist = (List<Integer>) closetMap.get(ch);
                int index = indexlist.size();
                indexlist.add(i);
                indexMap.put(i,index);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer num : queries) {
            Character ch = s.charAt(num);
            Integer indexInList = (Integer)indexMap.get(num);
            List<Integer> indexlist = (List<Integer>)closetMap.get(ch);
            int mid = indexlist.get(indexInList);
            int left =-1;
            int right = -1;
            if (indexInList > 0) left = indexlist.get(indexInList - 1);
            if (indexInList + 1 < indexlist.size()) right = indexlist.get(indexInList + 1);

            if (left == -1 && right == -1) {
                result.add(-1);
            } else if (left == -1 && right != -1){
                result.add(right);
            } else if (left != -1 && right == -1){
                result.add(left);
            } else {
                int leftDiff = mid - left;
                int rightDiff = right - mid;
                if (leftDiff < rightDiff) result.add(left);
                else if (leftDiff > rightDiff) result.add(right);
                else result.add(left);
            }
        }
        return result;
    }
}
