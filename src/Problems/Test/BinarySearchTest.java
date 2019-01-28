package Problems.Test;

import Tool.Common;
import Tool.Printer;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.*;

/**
 * Created by shuhanliu on 1/22/19.
 *
 * Test BinarySearch
 *
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int len = 10;
        int maxVal = 20;
        int iterations = 10;

        Set<Integer> used = new HashSet<>();
        Random rand = new Random();

        int[] arr = new int[len];
        int[] indexArr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            int val = rand.nextInt(maxVal);
            while (used.contains(val)) {
                val = rand.nextInt(maxVal);
            }
            arr[i] = val;
            indexArr[i] = i;
        }
        Arrays.sort(arr);
        Printer.printArrTab(arr);
        Printer.printArrTab(indexArr);

        int i = 1;
        while (i <= iterations) {
            int target = rand.nextInt((int)(maxVal * 1.5));
            if (target < maxVal*1.5*0.2) {
                target = 0 - target;
            }
            System.out.println("Target: " + target);
            System.out.println("Result from myBinarySearch1: " + Common.myBinarySearch1(arr, target));
            System.out.println("Result from myBinarySearch2: " + Common.myBinarySearch2(arr, target));
            System.out.println();
            i++;
        }
    }
}
