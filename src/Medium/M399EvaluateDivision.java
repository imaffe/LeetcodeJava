package Medium;

import java.util.*;

public class M399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<Set<String>> connectivitySets = new ArrayList<>();
        Map<String, Integer> setIdIndex = new HashMap<>();
        Map<String, Double> valueMap = new HashMap<>();
        for (int i = 0 ; i < equations.size(); i ++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0);
            String second = equation.get(1);

            int firstSetIndex = findSet(first, connectivitySets);
            int secondSetIndex = findSet(second, connectivitySets);

            if (firstSetIndex == -1 && secondSetIndex == -1) {
                int setId = createNewSet(connectivitySets, first, second);
                // use second as the base
                connectivitySets.get(setId).add(first);
                connectivitySets.get(setId).add(second);
                setIdIndex.put(second, setId);
                setIdIndex.put(first, setId);
                valueMap.put(second, 1.0);
                valueMap.put(first, values[i]);
            } else if (firstSetIndex == -1 && secondSetIndex != -1) {
                // add first to second
                connectivitySets.get(secondSetIndex).add(first);
                setIdIndex.put(first, secondSetIndex);
                valueMap.put(first, values[i] * valueMap.get(second));
            } else if (firstSetIndex != -1 && secondSetIndex == -1) {
                connectivitySets.get(firstSetIndex).add(second);
                setIdIndex.put(second, firstSetIndex);
                valueMap.put(second, valueMap.get(first)/values[i]);
            } else {
                // compact these two
                if (firstSetIndex == secondSetIndex) continue;
                else {
                    // use secondset as the base set
                    Set<String> firstSet= connectivitySets.get(firstSetIndex);
                    Set<String> secondSet = connectivitySets.get(secondSetIndex);
                    Iterator<String> iter = firstSet.iterator();
                    double ratio = values[i];
                    while(iter.hasNext()) {
                        String next = iter.next();
                        setIdIndex.put(next, secondSetIndex);
                        valueMap.put(next, valueMap.get(next) * ratio * valueMap.get(second) / valueMap.get(first));
                    }
                    secondSet.addAll(firstSet);
                    firstSet.clear();
                    // delete firstSet in the end TODO
                }
            }
        }

        double results[] = new double[queries.size()];
        // do the query
        for (int i = 0 ; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String first = query.get(0);
            String second = query.get(1);
            Integer firstSetIndex = setIdIndex.get(first);
            Integer secondSetIndex = setIdIndex.get(second);
            if (firstSetIndex == null || secondSetIndex == null) {
                results[i] = -1.0;
            } else if (firstSetIndex != secondSetIndex){
                results[i] = -1.0;
            } else {
                results[i] = valueMap.get(first) / valueMap.get(second);
            }
        }
        return results;
    }

    public int findSet(String target, List<Set<String>> sets) {
        for (int i = 0 ; i < sets.size(); i++) {
            Set<String> set = sets.get(i);
            if (set.contains(target)) {
                return i;
            }
        }
        return -1;
    }

    public int createNewSet(List<Set<String>> sets, String first, String second) {
        Set<String> newset = new HashSet<>();
        newset.add(first);
        newset.add(second);
        int index = sets.size();
        sets.add(newset);
        return index;
    }
}
