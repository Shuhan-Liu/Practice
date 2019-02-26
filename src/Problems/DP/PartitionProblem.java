package Problems.DP;

import Tool.Printer;

/**
 *
 * Created by shuhanliu on 2/25/19.
 *
 * Partition problem is to determine whether a given set can be partitioned
 * into two subsets such that the sum of elements in both subsets is same.
 *

 Examples:

 arr[] = {1, 5, 11, 5}
 Output: true
 The array can be partitioned as {1, 5, 5} and {11}

 arr[] = {1, 5, 3}
 Output: false
 The array cannot be partitioned into equal sum sets.
 *
 */
public class PartitionProblem {

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
//        int[] arr = {1, 5, 3};
        Printer.printResult(partition(arr));
    }

    public static boolean partition(int[] arr) {

        if (arr.length < 2)
            return false;

        int sum = 0;
        for (int i : arr)
            sum += i;

        if (sum % 2 != 0)
            return false;

        int half = sum / 2;

        // dp[i][j] represents the boolean that first i
        // elements can form a subset with sum j
        boolean[][] dp = new boolean[arr.length + 1][half + 1];

        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= half; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                    continue;
                }

                if (arr[i-1] <= j && dp[i-1][j-arr[i-1]]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[arr.length][half];
    }
}
