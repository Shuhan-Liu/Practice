package Problems.Tree;

import Structure.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhanliu on 10/10/18.
 */
public class FindLeaves {

    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> result = findLeaves(root);

        for (List<Integer> tmp : result) {
            for (Integer i : tmp) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        while (root != null) {
            List<Integer> curLeaves = new ArrayList<Integer>();
            root = removeCurrentLeaves(root, curLeaves);
            result.add(curLeaves);
        }
        return result;
    }

    public static TreeNode removeCurrentLeaves(TreeNode root, List<Integer> curLeaves) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null) {
            curLeaves.add(root.val);
            return null;
        }

        if (root.left != null) {
            root.left = removeCurrentLeaves(root.left, curLeaves);
        }

        if (root.right != null) {
            root.right = removeCurrentLeaves(root.right, curLeaves);
        }

        return root;
    }
}
