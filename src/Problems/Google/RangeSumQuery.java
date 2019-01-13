package Problems.Google;

import Tool.Printer;

/**
 * Created by shuhanliu on 1/12/19.
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.

 Example:

 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:

 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 */

class SegmentTreeNode{
    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}

class NumArray {
    private SegmentTreeNode root;

    public SegmentTreeNode getRoot() {
        return root;
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        SegmentTreeNode ret = new SegmentTreeNode(start, end);
        if (start == end)
            ret.sum = nums[start];
        else {
            int mid = start + (end - start) / 2;
            ret.left = buildTree(nums, start, mid);
            ret.right = buildTree(nums, mid + 1, end);
            ret.sum = ret.left.sum  + ret.right.sum;
        }

        return ret;
    }

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    public void update(int i, int val) {
        root.sum = update(i, val, root);
    }

    private int update(int i, int val, SegmentTreeNode node) {
        if (node.start == i && node.end == i) {
            node.sum = val;
            return node.sum;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (i <= mid) {
                return node.right.sum + update(i, val, node.left);
            } else {
                return node.left.sum + update(i, val, node.right);
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(i, j, root);
    }

    private int sumRange(int i, int j, SegmentTreeNode node) {
        if (i < node.start || i > node.end || j < node.start || j > node.end)
            return 0;
        int mid = node.start + (node.end - node.start) / 2;
        if (mid == node.start && mid == node.end)
            return node.sum;
        if (j <= mid) {
            return sumRange(i, j, node.left);
        } else if (i > mid) {
            return sumRange(i, j, node.right);
        } else {
            return sumRange(i, mid, node.left) + sumRange(mid+1, j, node.right);
        }

    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(i,val);
     * int param_2 = obj.sumRange(i,j);
     */
}

public class RangeSumQuery {

    public static void main (String[] args) {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);
        printLeaves(numArray.getRoot());
        System.out.println();
        Printer.printResult(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        Printer.printResult(numArray.sumRange(0, 2));
    }

    private static void printLeaves(SegmentTreeNode node) {
        if (node.start == node.end) {
            System.out.print(node.sum + " ");
        }
        else {
            printLeaves(node.left);
            printLeaves(node.right);
        }
    }
}
