package Problems.Phone;

import Structure.TreeNode;

import java.util.*;

/**
 * Created by shuhanliu on 1/23/19.
 */
public class MaxHeightToList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);

        System.out.println(getHeight(root));
        List<TreeNode> list = getLeavesOnMaxHeight(root);
        for (TreeNode node : list) {
            System.out.print(node.val + " ");
        }

    }

    public static List<TreeNode> getLeavesOnMaxHeight(TreeNode root) {
        int height = getHeight(root);
        List<TreeNode> list = new ArrayList<>();
        findLeavesOnMaxHeight(root, height, 1, list);
        return list;
    }

    public static void findLeavesOnMaxHeight(TreeNode node, int maxHeight, int curHeight, List<TreeNode> list) {
        if (curHeight > maxHeight || node == null)
            return;
        if (curHeight == maxHeight) {
            list.add(node);
            return;
        }

        findLeavesOnMaxHeight(node.left, maxHeight, curHeight + 1, list);
        findLeavesOnMaxHeight(node.right, maxHeight, curHeight + 1, list);
    }

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return 1 + Math.max(leftH, rightH);
    }
}
