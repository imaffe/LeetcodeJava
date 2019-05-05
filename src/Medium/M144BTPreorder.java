package Medium;

import java.util.ArrayList;
import java.util.List;

public class M144BTPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        wrappedPreorder(root, result);
        return result;
    }
    public void wrappedPreorder(TreeNode root, List<Integer> result) {
         if (root == null) return;

         result.add(root.val);
         wrappedPreorder(root.left, result);
         wrappedPreorder(root.right, result);
    }
}
