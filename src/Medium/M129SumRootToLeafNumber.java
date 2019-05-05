package Medium;

public class M129SumRootToLeafNumber {
    public int sumNumbers(TreeNode root) {
        return wrappedSum(root, 0);
    }
    public int wrappedSum(TreeNode root, int last) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return last * 10 + root.val;
        }
        int curValue = root.val;
        int sum = 0;
        int left = 0;
        int right = 0;
        if (root.left != null) left = wrappedSum(root.left, 10 * last + curValue);
        if (root.right != null) right = wrappedSum(root.right, 10*last + curValue);
        return left + right;
    }
}
