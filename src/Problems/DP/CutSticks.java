package Problems.DP;

import java.util.IntSummaryStatistics;

/**
 * Created by shuhanliu on 10/7/18.
 */
public class CutSticks {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 3, 2, 1};
        int[] arr2 = {5, 4, 4, 2, 2, 8};
        cutSticks(arr2);
    }

    public static void cutSticks(int[] arr) {

        boolean finished = false;
        while(!finished) {
            finished = true;
            int min = Integer.MAX_VALUE;
            int count = 0;
            for (Integer i : arr) {
                if (i > 0) {
                    count ++;
                    if (i < min) {
                        min = i;
                    }
                }
            }
            if (count > 0) {
                finished = false;
                System.out.println(count);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    arr[i] -= min;
                }
            }
        }
    }
}
