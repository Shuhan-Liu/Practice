package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/24/19.
 *
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that
 * the sum of elements in both subsets is equal.

 Note:

 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionEqualSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1};
        Printer.printResult(canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {

        if (nums.length < 2)
            return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        int half = sum / 2;

        // dp[i][j] indicates whether first i
        // elements can have a subset with sum j
        boolean[][] dp = new boolean[nums.length + 1][half + 1];

        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                dp[i][j] = dp[i-1][j];

                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        Printer.print2DArray(dp);

        return dp[nums.length][half];
    }
}
