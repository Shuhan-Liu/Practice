package Problems.Tree;

import Structure.TreeNode;

import java.util.Stack;

/**
 * Created by shuhanliu on 10/21/18.
 */
public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        while (node != null){
            stack.push(node);
            node = node.left;
        }

        if (!stack.isEmpty() && stack.peek().right != null) {
            TreeNode curNode = stack.pop();
            addRightTree(stack, curNode.right);
            stack.push(curNode);
        }

//        Common.printTreeNodeStack(stack);
    }

    public void addRightTree(Stack<TreeNode> stack, TreeNode node) {
        TreeNode n = node;
//        System.out.println(n == null);

        while (n != null) {
            stack.push(n);
            n = n.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int rtn = node.val;

        if (!stack.isEmpty()) {

            TreeNode nextNode = stack.pop();
            if (nextNode.right != null) {
                addRightTree(stack, nextNode.right);
//                TreeNode n = nextNode.right;
//
//                while (n != null) {
//                    stack.push(n);
//                    n = n.left;
//                }
            }
            stack.push(nextNode);
        }
//        Common.printTreeNodeStack(stack);
        return rtn;
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        BSTIterator iterator = new BSTIterator(root);

//        int i = 5;

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
//            i--;
        }
        System.out.println();
    }
}
