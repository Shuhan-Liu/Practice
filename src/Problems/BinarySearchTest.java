package Problems;

import Tool.Common;

/**
 * Created by shuhanliu on 10/27/18.
 */
public class BinarySearchTest {

    public static void main (String[] args) {
        int[] arr = {5,7,7,8,8,8,10};
        int[] targets = {0, 2, 5, 6, 7, 8, 9, 10, 11, 20};

        System.out.println("---------------------------------------");
        for (int target : targets) {
            Common.printArr(arr);
            System.out.println("TARGET: " + target);
            System.out.println("RESULT: " + binarySearch(arr, target));
            System.out.println("---------------------------------------");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // left <= right when right starts
        // at arr.length - 1
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // in this kind of binary search
        // left represent the insert position of an element
        // right is the index before left
        return left;
    }
}
