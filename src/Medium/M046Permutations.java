package Medium;

import java.util.ArrayList;
import java.util.List;

public class M046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int[] vector = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) vector[i] = i;
        List<List<Integer>> result = new ArrayList<>();
        boolean init = true;
        while (init) {
            List<Integer> oneSol = new ArrayList<>();
            for (int i = 0 ; i < nums.length; i++) {
                oneSol.add(nums[vector[i]]);
            }
            result.add(oneSol);
            init = nextPermuation(vector);
        }
        return result;
    }
    public boolean nextPermuation(int[] vector) {
        int largest = -1;
        int turn = vector.length;
        for (int i = vector.length -1; i >= 0; i--) {
            if (vector[i] > largest) largest = vector[i];
            else {
                turn = i;
                break;
            }
        }
        if (turn == vector.length) return false;
        int nextBigger = vector.length;
        for (int i = vector.length -1; i >= turn + 1; i--) {
            if (vector[i] > vector[turn]) {
                nextBigger = i;
                break;
            }
        }

        // do the swap
        swap(vector, turn, nextBigger);
        // do the reverse
        for (int i = turn + 1, j = vector.length - 1; i <= j; i++, j--) {
            swap(vector, i, j);
        }
        return true;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
