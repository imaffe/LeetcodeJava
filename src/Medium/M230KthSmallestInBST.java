package Medium;

public class M230KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        return findK(root, k);
    }

    private int findK(TreeNode root, int k) {
        if(root == null) return 0;// no solution
        int leftSize = findSize(root.left);
        if (leftSize  + 1 == k) return root.val;
        else if (leftSize >= k) return findK(root.left, k);
        else {
            return findK(root.right, k - leftSize - 1);
        }
    }

    private int findSize(TreeNode root) {
        if (root == null) return 0;
        return (findSize(root.left) + 1 + findSize(root.right));
    }
}
