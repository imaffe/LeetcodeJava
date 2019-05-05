package Medium;

import java.util.ArrayList;
import java.util.List;

public class M279PerfectSquare {
    public int numSquares1(int n) {
        // fisrt we use a very silly solution, but we need to practice 'speaking Java'
        int largest = (int) Math.sqrt(n);

        int min = 1000000;
        for (int i = largest; i >= 1; i --) {
            if (largest * largest * min <= n) break;
            List<List<Integer>> oneSubSol = findSolUsedLargest(n, i);
            // here we can even use a findMinSolUsedLargest
            for (int j = 0; j < oneSubSol.size(); j++) {
                int cursize = oneSubSol.get(j).size();
                if (cursize < min) {
                    min = cursize;
                }
            }

        }
        return min;
    }

    private List<List<Integer>> findSol(int n, int largest) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = largest; i >= 1; i--) {
            List<List<Integer>> oneSolSet = findSolUsedLargest(n, i);
            result.addAll(oneSolSet);
        }
        return result;
    }

    private List<List<Integer>> findSolUsedLargest(int n, int largest) {
        int squareLargest = largest * largest;
        List<List<Integer>> result = new ArrayList<>();
        if (n - squareLargest == 0) {
            List<Integer> oneSol = new ArrayList<>();
            oneSol.add(largest);
            result.add(oneSol);
            return result;
        } else if (n - squareLargest < 0) return result;
        else {
            List<List<Integer>> subSols = findSol(n - squareLargest, largest);

            for (int i = 0 ; i < subSols.size(); i++) {
                subSols.get(i).add(largest);
            }
            return subSols;
        }
    }

    // the above still not working
    public int numSquares2(int n) {
        // fisrt we use a very silly solution, but we need to practice 'speaking Java'
        int largest = (int) Math.sqrt(n);

        int min = 100000;
        for (int i = largest; i >= 1; i --) {
            if (i * i * min <= n) break;
            int curmin = findMinSolUsedLargest(n, i);
            if (curmin != -1 && curmin < min) min = curmin;
        }
        return min;
    }

    private int findMinSolUsedLargest(int n, int largest) {
        int squareLargest = largest * largest;
        if ( n - squareLargest == 0) {
            return 1;
        } else if (n - squareLargest > 0) {
            int min = 100000;
            for (int i = largest; i >= 1; i --) {
                if (i * i * min <= n - squareLargest) break;
                int curmin = findMinSolUsedLargest(n - squareLargest, i);
                if (curmin != -1 && curmin < min) min = curmin;
            }
            return min + 1;
        } else {
            return -1;
        }
    }

    // the above solution is completely time consuming
    // have to think a better way.
    public int numSquares(int n) {
        // fisrt we use a very silly solution, but we need to practice 'speaking Java'
        int largest = (int) Math.sqrt(n);
        // list all squares, and see what calculate all 1 sum, 2 sum and more sum, search every layer.
        return 0;
    }
}
