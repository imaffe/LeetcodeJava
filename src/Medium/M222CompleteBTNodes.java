package Medium;

public class M222CompleteBTNodes {
    public int countNodes(TreeNode root) {
        int maxDepth = findMaxDepth(root);
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int results[] = new int[1];
        searchEnd(root, 1, maxDepth, 1, results);
        return (int) Math.pow(2,maxDepth - 1) - 1 + results[0];
    }

    private int findMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + findMaxDepth(root.left);
    }

    private boolean searchEnd(TreeNode root, int depth, int maxDepth, int curIndex, int[] results) {
        if (depth == maxDepth - 1) {
            if (root.left == null && root.right == null) {
                return true;
            } else if (root.left != null && root.right == null) {
                results[0] += 1;
                return true;
            } else {
                results[0] += 2;
                return false;
            }


        } else {
            boolean res = searchEnd(root.left, depth + 1, maxDepth, (curIndex - 1) * 2 + 1, results);
            if (!res) res = searchEnd(root.right, depth + 1, maxDepth, (curIndex - 1) * 2 + 2, results);
            return res;
        }
    }

}

// result[0] : index
// result[1] :
// 1.