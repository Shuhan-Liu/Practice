package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/21/19.
 *
 * Given a set of integers, the task is to divide it into two sets
 * S1 and S2 such that the absolute difference between their sums is minimum.

 If there is a set S with n elements, then if we assume Subset1 has m elements,
 Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2))
 should be minimum.

 Example:

 Input:  arr[] = {1, 6, 11, 5}
 Output: 1
 Explanation:
 Subset1 = {1, 5, 6}, sum of Subset1 = 12
 Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumPartition {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};

//        Printer.printResult(minDiffRecur(arr));
        Printer.printResult(minDiff(arr));
    }

    // Idea: Similar to PartitionEqualSum in this folder
    // we can create the same dp arr represent
    // there exist a subset of first i elements sum to j
    // Then, calculate the min arr[i] that
    // let dp[arr.length][j-arr[i]/2] = true
    public static int minDiff(int[] arr) {

        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        boolean[][] dp = new boolean[arr.length+1][sum+1];
        dp[0][0] = true;

        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        // first step, calculate the dp array
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                }

                if (j - arr[i-1] >= 0 && dp[i-1][j-arr[i-1]]) {
                    dp[i][j] = true;
                }
            }
        }


        // second step, find the minimum number in arr
        // that can let the the remaining array be split
        // into two subsets with equal sum
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            if ((sum - i )%2 == 0 && dp[arr.length][(sum - i )/2]) {
                min = Math.min(min, i);
            }
        }

        return min;
    }

//    public static int minDiffRecur(int[] arr) {
//
//        int total = 0;
//        for (int i : arr)
//            total += i;
//
//        return helper(arr, arr.length, 0, total);
//    }
//
//    public static int helper(int[] arr, int curIndex, int curSum, int total) {
//
//        if (curIndex == 0)
//            return Math.abs((total - curSum) - curSum);
//
//        return Math.min(helper(arr, curIndex-1, curSum + arr[curIndex-1], total),
//                        helper(arr, curIndex-1, curSum                  , total));
//    }
}
