package Problems.Google;

import Tool.Printer;

import java.util.Random;

/**
 * Created by shuhanliu on 1/17/19.
 */
public class RangeMaxQuery {

    static class SegmentTreeNode{
        int left;
        int right;
        int max;
        SegmentTreeNode leftTree;
        SegmentTreeNode rightTree;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 1, 7, 6, 9, 2, 1, 3};
        int[] ind = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        SegmentTreeNode root = constructTree(arr, 0, arr.length-1);
        int n = 5;
        Random random = new Random();
        for (int i = 1; i<= 5; i++) {
            int random1 = random.nextInt(arr.length);
            int random2 = random.nextInt(arr.length);
            if (random1 < random2) {
                System.out.println("left: " + random1 + " right: " + random2);
                Printer.printResult(findMax(root, random1, random2));
            } else if (random2 < random1){
                System.out.println("left: " + random2 + " right: " + random1);
                Printer.printResult(findMax(root, random2, random1));
            } else {
                i--;
            }
        }
    }

    public static int findMax(SegmentTreeNode root, int start, int end) {
        if (root.left == root.right)
            return root.max;
        int mid = root.left + (root.right - root.left) / 2;
        if (end <= mid) {
            return findMax(root.leftTree, start, end);
        } else if (start >= mid) {
            return findMax(root.rightTree, start, end);
        } else {
            return Math.max(findMax(root.leftTree, start, mid), findMax(root.rightTree, mid+1, end));
        }
    }

    public static SegmentTreeNode constructTree(int[] arr, int left, int right) {
        SegmentTreeNode node = new SegmentTreeNode();
        node.left = left;
        node.right = right;
        if (left == right) {
            node.max = arr[left];
        } else {
            int mid = mid = left + (right - left) / 2;
            SegmentTreeNode leftTree = constructTree(arr, left, mid);
            SegmentTreeNode rightTree = constructTree(arr, mid + 1, right);
            node.leftTree = leftTree;
            node.rightTree = rightTree;
            node.max = Math.max(leftTree.max, rightTree.max);
        }
        return node;
    }
}
