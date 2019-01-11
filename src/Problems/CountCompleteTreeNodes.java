package Problems;

import Structure.TreeNode;

/**
 * Created by shuhanliu on 12/15/18.
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        System.out.println("val: " + root.val + " leftDepth: " + leftDepth + " rightDepth: " + rightDepth);

        if (leftDepth == rightDepth) {
//            count += Math.pow(2, leftDepth) - 1;
            count += (1 << leftDepth) - 1;
            count += countNodes(root.right);
        } else if (leftDepth > rightDepth) {
//            count += Math.pow(2, rightDepth) - 1;
            count += (1 << rightDepth) - 1;
            count += countNodes(root.left);
        }

        // remember to add itself!!!
        count += 1;

        return count;
    }

    public static int getDepth(TreeNode root) {
        TreeNode p = root;
        int count = 0;
        while (p != null) {
            count ++;
            p = p.left;
        }
        return count;
    }
}
