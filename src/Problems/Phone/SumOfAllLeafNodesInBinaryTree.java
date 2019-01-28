package Problems.Phone;

import Structure.TreeNode;
import Tool.Printer;
import java.util.*;

/**
 * Created by shuhanliu on 1/26/19.
 */
public class SumOfAllLeafNodesInBinaryTree {

    static class Node{
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);

        Printer.printResult(sumOfAllLeafNodesInBinaryTree(root));
        Printer.printResult(sumOfAllLeafNodesInBinaryTreeIterative(root));

        Node node = new Node(5);
        node.left = new Node(3);
        node.left.parent = node;
        node.right = new Node(6);
        node.right.parent = node.right;
        node.right.left = new Node(7);
        node.right.left.parent = node.right.left;
        Printer.printResult(sumOfAllLeafNodesInBinaryTreeIterative(node));
    }

    public static int sumOfAllLeafNodesInBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        int leftSum = sumOfAllLeafNodesInBinaryTree(root.left);
        int rightSum = sumOfAllLeafNodesInBinaryTree(root.right);

        return leftSum + rightSum;
    }

    public static int sumOfAllLeafNodesInBinaryTreeIterative(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node.left == null && node.right == null) {
                sum += node.val;
            }
        }
        return sum;
    }

    public static int sumOfAllLeafNodesInBinaryTreeIterative(Node root) {
        if (root == null)
            return 0;
        int sum = 0;
        Node prev = new Node(0);
        Node cur = root;
        cur.parent = prev;

//        while (cur != null) {
//            if (cur.left == null && cur.right == null) {
//                sum += cur.val;
//                prev = cur;
//                cur = cur.parent;
//            } else {
//                if (cur.left != null && cur.left != prev) {
//                    prev = cur;
//                    cur = cur.left;
//                } else if (cur.right != null && cur.right != prev) {
//                    prev = cur;
//                    cur = cur.right;
//                }
//            }
//        }

        while (cur != null) {
            if (cur.left == null && cur.right == null) {
                sum += cur.val;
                if (prev.right != null) {
                    cur = prev.right;
                } else {
                    cur = prev.parent;
                }
            } else {
                if (cur.left != null && prev != cur.right) {
                    prev = cur;
                    cur = cur.left;
                }
            }
        }

        return sum;
    }
}
