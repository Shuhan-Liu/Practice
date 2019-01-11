package Problems;

import Tool.Common;

import java.util.Arrays;

/**
 * Created by shuhanliu on 10/7/18.
 *
 * For each element in 1st array count elements less than or equal to it in 2nd array
 *
 */
public class SimpleQuery {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 7, 9};
        int[] arr2 = {0, 1, 2, 1, 1, 4};

        int[] result = simpleQuery(arr1, arr2);
        Common.printArr(result);

//        int[] arr = {0, 1, 1, 1, 2, 4};
//        System.out.println("POS: " + Arrays.binarySearch(arr, 1));
    }

    public static int[] simpleQuery(int[] arr1, int[] arr2) {
        int[] rtn = new int[arr1.length];

//        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Common.printArr(arr1);
        Common.printArr(arr2);

//        for (int i = 0; i < arr1.length; i++) {
//            if (i-1 >=0 && arr1[i-1] == arr1[i]) {
//                rtn[i] = rtn[i - 1];
//                continue;
//            }
//
//            int pos = Arrays.binarySearch(arr2, arr1[i]);
//            if (pos < 0)
//                pos = 0 - (pos + 1);
//            System.out.println(arr1[i] + " : " + pos);
//            rtn[i] = pos + 1;
//        }

        for (int i = 0; i < arr1.length; i++) {
            rtn[i] = myBinarySearch(arr2, arr1[i]) + 1;
            System.out.println(arr1[i] + " : " + rtn[i]);
        }

        return rtn;
    }

    public static int myBinarySearch(int[] arr, int target) {
        if (target < arr[0])
            return -1;
        if (target < arr[1])
            return arr.length - 1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
        }

        return right;
    }

    public static int binarySearch(int[] arr, int target) {
        if (target < arr[0])
            return -1;
        if (target < arr[1])
            return arr.length - 1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                return mid;
        }

        return left;
    }
}
