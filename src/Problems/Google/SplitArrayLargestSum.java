package Problems.Google;

import Tool.Printer;

/**
 * Created by shuhanliu on 1/13/19.
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 If n is the length of array, assume the following constraints are satisfied:

 1 ≤ n ≤ 1000
 1 ≤ m ≤ min(50, n)
 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.

 解法：2D的dp 前j个数字分成i份 = min（max（前j-k个数字分成i-1份， sum（k+1，j））
 */
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        Printer.printResult(splitArray(nums, m));
    }

    public static int splitArray(int[] nums, int m) {
        int[][] dp = new int[m+1][nums.length];
        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        for (int j = 0; j < nums.length; j++) {
            dp[1][j] = sums[j];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k], sums[j] - sums[k]));
                }
            }
        }
        return dp[m][nums.length-1];
    }
}
