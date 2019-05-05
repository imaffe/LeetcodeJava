package Medium;

import java.util.*;

public class M199BtRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode cur = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = 1;
        int nextsize = 0;
        while (!queue.isEmpty()) {
            nextsize = 0;
            for (int i = 0 ; i < size; i++) {

                cur = queue.poll();
                if (i == size - 1) result.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                    nextsize++;
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                    nextsize++;
                }
            }
            size = nextsize;
        }
        return result;
    }
}
