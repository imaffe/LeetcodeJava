package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class M433MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        // build a neighboring graph
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> currentSet = new HashSet<>();
        currentSet.add(start);
        // TODO if start equals end
        int res = findMin(currentSet, end, bankSet);
        return res;

    }

    public int findMin(Set<String> candiadates, String end, Set<String> bank) {


        Iterator<String> candiIter = candiadates.iterator();
        while (candiIter.hasNext()) {
            if (candiIter.next().equals(end)) return 0;
        }
        // if not found
        Iterator<String> bankIter = bank.iterator();
        HashSet<String> nextCandiadates = new HashSet<>();
        HashSet<String> newBank = new HashSet<>(bank);
        while (bankIter.hasNext()) {
            String nextBank = bankIter.next();
            Iterator<String> iter = candiadates.iterator();
            while(iter.hasNext()) {
                if (isNeighbor(iter.next(), nextBank)) {
                    if (nextBank.equals(end)) {
                        return 1;
                    }
                    nextCandiadates.add(nextBank);
                    newBank.remove(nextBank);
                    break;
                }
            }
        }

        if (nextCandiadates.isEmpty()) return -1;
        int res = findMin(nextCandiadates, end, newBank);
        if (res == -1) return -1;
        else return res + 1;

    }
    public boolean isNeighbor(String a, String b) {
        if (a.length() != b.length()) return false;
        int notEqualCount = 0;
        for (int i = 0 ; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) notEqualCount ++;
            if (notEqualCount > 1) return false;
        }
        return true;
    }
}
