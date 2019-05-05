package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class M064MinimusPathSum {
    public int minPathSum(int[][] grid) {
        int rowLength = grid.length;
        if (rowLength == 0) return 0;
        int colLength = grid[0].length;
        int [] dr = {0, 1};
        int [] dc = {1, 0};
        int curR = 0, curC = 0;
        Stack<Integer> stack = new Stack<>();
        int minPath = 1000000;
        return backtracking(grid, stack, rowLength, colLength, minPath, curR, curC);

    }
    public int backtracking(int[][] grid, Stack<Integer> stack, int r, int c, int min, int curR, int curC) {
        int sum = calSum(stack, grid);
        if (sum >= min) return min;
        if (stack.size() == r + c - 2) {
            if (sum < min) min = sum;
            return min;
        }

        if (curR < r - 1) {
            stack.push(0);
            curR ++;
            backtracking(grid, stack, r, c, min, curR, curC);
            stack.pop();
            curR --;
        }
        if (curC < c - 1) {
            stack.push(1);
            curC ++;
            backtracking(grid, stack, r, c, min, curR, curC);
            stack.pop();
            curC --;
        }

        // TODO need to fix
        return -1231424;
    }
    public int calSum(Stack<Integer> stack, int[][] grid) {
        Iterator<Integer> iter = stack.iterator();
        int sum = grid[0][0], row = 0, col = 0;
        while (iter.hasNext()) {
            if (iter.next() == 0) {
                col ++ ;
                sum += grid[row][col];
            } else {
                row ++;
                sum += grid[row][col];
            }
        }
        return sum;
    }
}
