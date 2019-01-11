package Problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import Tool.Common;

/**
 * Created by shuhanliu on 10/7/18.
 *
 * Sort array of integers in ascending order based on number of 1s in their
 * binary representation.
 */
public class AscendingBinarySorting {
    public static void main (String[] args) {
//        int[] arr = {3, 5, 1, 8, 2, 15, 85};
        int[] arr = {7, 8, 6, 5};
        Common.printArr(arr);
        int[] sorted = ascendingBinarySort(arr);
        Common.printArr(sorted);
        int[] ones = new int[arr.length];
        int i = 0;
        for (Integer a : sorted) {
            ones[i] = countOnes(a);
            i++;
        }
        Common.printArr(ones);
    }

    public static int[] ascendingBinarySort(int[] arr) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1One = countOnes(o1);
                int o2One = countOnes(o2);

                if (o1One == o2One)
                    return o1 - o2;
                else
                    return o1One - o2One;

            }
        });

        for (Integer i : arr) {
            queue.offer(i);
        }

        int[] rtn = new int[queue.size()];
        int i = 0;
        while(!queue.isEmpty()) {
            rtn[i] = queue.poll();
            i++;
        }
        return rtn;
    }

    public static int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) > 0)
                count++;
            num >>= 1;
        }
        return count;
    }
}
