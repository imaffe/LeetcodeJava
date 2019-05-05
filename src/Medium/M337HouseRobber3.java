package Medium;

public class M337HouseRobber3 {
    public int rob(TreeNode root) {
        Result res = robNode(root);
        if (res != null) return Math.max(res.include, res.exclude);
        else return 0;
    }

    public Result robNode(TreeNode root) {
        if (root == null) return new Result(0,0);
        Result left = robNode(root.left);
        Result right = robNode(root.right);
        int include = 0;
        int exclude = 0;
        include += (left.exclude + right.exclude + root.val);
        exclude += (Math.max(left.exclude, left.include) + Math.max(right.exclude, right.include));
        return new Result(include, exclude);
    }

    public class Result {
        public int include;
        public int exclude;
        public Result(int x, int y) {
            this.include = x;
            this.exclude = y;
        }
    }
}
