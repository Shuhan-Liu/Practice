package Problems.Onsite;

import Structure.TreeNode;
import Tool.Printer;

/**
 * Created by shuhanliu on 3/3/19.
 *
 * Follow up: 给一棵二叉搜索树，有一条多余边，删除它
 例子：
       7
     /  \
    5    9
  /  \   /
 3     8
 对于多余边5-8，9-8此处的删除需要有选择，跟之前的题目找到多余边立马不分选择删除有区别
 */
public class RedundantConnectionFollowUp {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.left = root.left.right;

        deleteRedundantEdgeInBST(root);
        Printer.printResult(root.left.right == null);
    }

    public static TreeNode deleteRedundantEdgeInBST(TreeNode root) {
        root = dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    public static TreeNode dfs(TreeNode root, int min, int max) {
        if (root == null)
            return null;
        if (root.val >= max || root.val <= min) return null;
        root.left = dfs(root.left, min, root.val);
        root.right = dfs(root.right, root.val, max);
        return root;
    }
}
