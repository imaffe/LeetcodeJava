package Medium;

public class M236CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return findCommon(root, p, q);
    }

    private TreeNode findCommon(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode result = findCommon(root.left, p , q);
        if (result == null) {
            result = findCommon(root.right, p , q);
        } else return result;

        if (result == null) {
            if (p == root) {
                return (findIn(root.left, q) || findIn(root.right, q)) ? root : null;
            } else if (q == root) {
                return (findIn(root.left, p) || findIn(root.right, p)) ? root : null;
            } else {
                boolean lr = findIn(root.left, q) && findIn(root.right, p);
                boolean rl = findIn(root.left, p) && findIn(root.right, q);
                return (lr || rl) ? root : null;
            }
        }
        else return result;
    }

    private boolean findIn(TreeNode root, TreeNode target) {
        if (root == null) return false;

        return (root == target || findIn(root.left, target) || findIn(root.right, target));
    }
}
