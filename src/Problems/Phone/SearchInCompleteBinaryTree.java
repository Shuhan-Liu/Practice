package Problems.Phone;

import Structure.TreeNode;

/**
 * Created by shuhanliu on 1/23/19.
 */
public class SearchInCompleteBinaryTree {

    public static void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

//        System.out.print(contains(root, 5));
    }

    public static boolean contains(TreeNode root, int val) {
        if (root == null)
            return false;

        TreeNode p = root;
        int leftMost = root.val;
        while (p != null) {
            leftMost = p.val;
            p = p.left;
            if (leftMost >= val)
                return true;
        }



        return false;
    }
}
