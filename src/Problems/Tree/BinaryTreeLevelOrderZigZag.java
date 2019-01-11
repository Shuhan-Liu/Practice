package Problems.Tree;

import Structure.TreeNode;
import Tool.Common;

import java.util.*;

/**
 * Created by shuhanliu on 10/21/18.
 */
public class BinaryTreeLevelOrderZigZag {

    static class Tuple {
        TreeNode node;
        int level;

        public Tuple (TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        Common.print2DIntegerList(result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Tuple> queue = new LinkedList<>();

        int curLevel = 1;
        queue.offer(new Tuple(root, curLevel));
        List<Integer> tmp = new ArrayList<>();

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            Tuple curTuple = queue.poll();

            if (curTuple.level == curLevel) {
                tmp.add(curTuple.node.val);
            } else {
                if (leftToRight) {
                    result.add(new ArrayList<>(tmp));
                    leftToRight = false;
                } else {
                    Collections.reverse(tmp);
                    result.add(new ArrayList<>(tmp));
                    leftToRight = true;
                }

                curLevel = curTuple.level;
                tmp.clear();
                tmp.add(curTuple.node.val);
            }

            if (curTuple.node.left != null) {
                queue.offer(new Tuple(curTuple.node.left, curLevel+1));
            }

            if (curTuple.node.right != null) {
                queue.offer(new Tuple(curTuple.node.right, curLevel+1));
            }
        }

        if (!tmp.isEmpty()) {
            if (leftToRight) {
                result.add(new ArrayList<>(tmp));
            } else {
                Collections.reverse(tmp);
                result.add(new ArrayList<>(tmp));
            }
        }

        return result;
    }


}
