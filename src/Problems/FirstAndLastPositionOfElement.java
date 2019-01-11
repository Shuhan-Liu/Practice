package Problems;

import Tool.Common;

/**
 * Created by shuhanliu on 10/27/18.
 *
 * nums is an ascending array
 *
 * target is the integer you want
 *
 */
public class FirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target) {
        int[] rtn = new int[2];

        if (nums.length == 0) {
            rtn[0] = -1;
            rtn[1] = -1;
            return rtn;
        }

        if (nums.length == 1) {
            if (nums[0] != target) {
                rtn[0] = -1;
                rtn[1] = -1;
            }
            return rtn;
        }

        int firstPos = findFirstPos(nums, target);
        int lastPos = findLastPos(nums, target);

        System.out.println("FIRST POS: " + firstPos);
        System.out.println("LAST POS: " + lastPos);

        if (firstPos > 0 && firstPos < nums.length && nums[firstPos] != target) {
            firstPos = -1;
            lastPos = -1;
        }

        rtn[0] = firstPos;
        rtn[1] = lastPos;

        return rtn;
    }

    public static void main (String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

//        int[] nums = {2, 2};
//        int target = 2;

        int[] rtn = searchRange(nums, target);
        System.out.print("RESULT: ");
        Common.printArr(rtn);
    }

    public static int findFirstPos (int[] nums, int target) {

        if (target < nums[0])
            return -1;
        if (target > nums[nums.length-1])
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid > 0 && nums[mid - 1] < target)
                    return mid;
                right = mid - 1;
            }
        }

        return left;
    }

    public static int findLastPos(int[] nums, int target) {
        if (target < nums[0])
            return -1;
        if (target > nums[nums.length-1])
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid < nums.length-1 && nums[mid + 1] > target)
                    return mid;
                left = mid + 1;
            }
        }

        // in this kind of binary search
        // left represent the insert position of an element
        // right is the index before left
        return right;
    }
}
