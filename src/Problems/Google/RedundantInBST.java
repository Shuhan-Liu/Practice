package Problems.Google;

import Structure.TreeNode;

/**
 * Created by shuhanliu on 1/6/19.
 */
public class RedundantInBST {
    public static void main (String args) {

    }

    public void deleteEdge(TreeNode root) {
        if(root == null) return;
        root = dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode dfs(TreeNode root, int left, int right) {
        if(root == null)
            return root;
        if(root.val <= left || root.val >= right)
            return null;
        root.left = dfs(root.left, left, root.val);
        root.right = dfs(root.right, root.val, right);
        return root;
    }

}
