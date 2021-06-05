package Medium;

public class AmzHighFreq016DistanceBetweenNodes {
    public int shortest(int[] nums, int a, int b) {
        // create a binary tree
        int len = nums.length;
        if (len == 0) return 0;
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1 ; i < len; i++) {
            insertInto(nums[i], root);
        }
        // use binary search to find the common root (the first node in between)
        TreeNode commonRoot = null;
        if (a < b) {
            commonRoot = findCommonRoot(root, a ,b);
        } else {
            commonRoot = findCommonRoot(root, b ,a);
        }


        int hA = findHeight(commonRoot, a);
        int hB = findHeight(commonRoot, b);
        return hA + hB;
        // then find the height of a and b from that node
    }

    public void insertInto(int num, TreeNode parent) {
        if (num > parent.val) {
            if(parent.right == null) {
                TreeNode newnode = new TreeNode(num);
                parent.right = newnode;
            } else {
                insertInto(num, parent.right);
            }
        } else {
            if(parent.left == null) {
                TreeNode newnode = new TreeNode(num);
                parent.left = newnode;
            } else {
                insertInto(num, parent.left);
            }
        }
    }

    public TreeNode findCommonRoot(TreeNode root, int low, int high) {
        int cur = root.val;
        if (cur < high && cur > low) {
            return root;
        } else if (cur < low) {
            return findCommonRoot(root.right, low, high);
        } else if (cur > high){
            return findCommonRoot(root.left, low, high);
        } else return null;
    }

    public int findHeight(TreeNode root, int target) {
        int cur = root.val;
        if (target == cur) {
            return 0;
        } else if (target < cur) {
            return 1 + findHeight(root.left, target);
        } else if (target > cur) {
            return 1 + findHeight(root.right, target);
        } else return -1;
    }
}
