package Problems.Onsite.dataStructure;

import Structure.TreeNode;
import Tool.Printer;

/**
 * Created by shuhanliu on 3/17/19.
 *
 * LC 951 Tree Isomorphism Problem
 *
 * For a binary tree T, we can define a flip operation as follows:
 * choose any node, and swap the left and right child subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y
 * if and only if we can make X equal to Y after some number of flip operations.
 *
 * Write a function that determines whether two binary trees are flip equivalent.
 * The trees are given by root nodes root1 and root2.
 */
public class TreeIsomorphism {

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        boolean noNeedToFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flipWillFix = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        if (noNeedToFlip || flipWillFix)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.right = new TreeNode(7);
        root2.right.right.left = new TreeNode(8);
        root2.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);

        Printer.printResult(flipEquiv(root1, root2));
    }
}
