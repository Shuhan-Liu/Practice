package Problems.Google;

import Structure.TreeNode;
import Tool.Printer;

/**
 * Created by shuhanliu on 1/10/19.
 */
public class SearchIndexInBT {

    public static void main (String[] args) {

        int key = -3;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(-6);
        root.left.right = new TreeNode(-3);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(12);

        Printer.printResult(searchInBt(key, root));
        Printer.printResult(countCompleteTreeNodes(root));
    }

    public static boolean searchInBt(int key, TreeNode root) {
        if (root == null)
            return false;
        if (root.val == key)
            return true;
        return searchInBt(key, root.left) || searchInBt(key, root.right);
    }

    public static int countCompleteTreeNodes(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        int leftDepth = countDepth(root.left);
        int rightDepth = countDepth(root.right);

        if (leftDepth == rightDepth) {
            count += Math.pow(2, leftDepth) - 1;
            count += countCompleteTreeNodes(root.right);
        } else {
            count += Math.pow(2, rightDepth) - 1;
            count += countCompleteTreeNodes(root.left);
        }

        return count + 1;
    }

    public static int countDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countDepth(root.left);
    }
}
