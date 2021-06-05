package Medium;

import java.util.*;

public class SF001GeographicalSort {
    public int[] geoSort(int[] ar1, int[]ar2) {
        Map<Integer, Integer> arr1 = new HashMap<>();
        Map<Integer, Integer> arr2 = new HashMap<>();
        for(Integer i  : ar1) {
            arr1.put(i, arr1.getOrDefault(i, 0) + 1);
        }
        for(Integer i  : ar2) {
            arr2.put(i, arr2.getOrDefault(i, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(Integer i : arr2.keySet()) {
            if(arr1.containsKey(i)) {
                int count = Math.min(arr1.get(i), arr2.get(i));
                for(int k = 0; k < count; k++) {
                    result.add(i);
                }
            }
        }
        result.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int[] resultArr = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;


    }
}
