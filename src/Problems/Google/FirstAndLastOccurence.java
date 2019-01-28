package Problems.Google;

import Tool.Common;
import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/22/19.
 */
public class FirstAndLastOccurence {

    public static void main(String[] args) {
//        int len = 10;
//        int maxVal = 20;
//        int iterations = 10;
//
//        Random rand = new Random();
//
//        int[] arr = new int[len];
//        int[] indexArr = new int[len];
//        for (int i = 0; i < arr.length; i++) {
//            int val = rand.nextInt(maxVal);
//            arr[i] = val;
//            indexArr[i] = i;
//        }
//        Arrays.sort(arr);
//        Printer.printArrTab(arr);
//        Printer.printArrTab(indexArr);

//        int i = 0;
//        while (i <= iterations) {
//            int target = rand.nextInt((int)(maxVal * 1.5));
//            if (target < maxVal*1.5*0.2) {
//                target = 0 - target;
//            }
//            System.out.println("Target: " + target);
//            System.out.println("First Occurence: " + findFitstOccurence(arr, target));
//            System.out.println();
//            i++;
//        }


        int[] arr = {1, 2, 2, 3, 3, 3, 3, 3, 7, 8, 8, 8, 10};
        int[] indexArr = new int[arr.length];
        for (int i = 0; i < indexArr.length; i++)
            indexArr[i] = i;
        int iterations = 10;
        Random rand = new Random();
        Printer.printArrTab(arr);
        Printer.printArrTab(indexArr);

        int i = 0;
        while (i <= iterations) {
            int target = rand.nextInt((int)(10 * 1.5));
            if (target < 10*1.5*0.2) {
//                target = 0 - target;
                target = 3;
            }
            System.out.println("Target: " + target);
            System.out.println("First Occurence: " + findFitstOccurence(arr, target));
            System.out.println("Last Occurence: " + findLastOccurence(arr, target));
            System.out.println();
            i++;
        }
    }

    public static int findFitstOccurence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
//            System.out.println("left: " + left + " mid: " + mid + " right: " + right);
            if (arr[mid] == target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < arr.length && arr[left] == target)
            return left;

        return -1;
    }

    public static int findLastOccurence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
//            System.out.println("left: " + left + " mid: " + mid + " right: " + right);
            if (arr[mid] == target) {
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0 && arr[right] == target)
            return right;

        return -1;
    }
}
