package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/20/19.
 *
 * 0-1 Knapsack Problem | DP-10

 Given weights and values of n items, put these items in a knapsack of
 capacity W to get the maximum total value in the knapsack.
 In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
 which represent values and weights associated with n items respectively.
 Also given an integer W which represents knapsack capacity,
 find out the maximum value subset of val[] such that sum of the weights
 of this subset is smaller than or equal to W. You cannot break an item,
 either pick the complete item, or don’t pick it (0-1 property).

 knapsack-problem

 int[] values = {60, 100, 120};
 int[] weights = {10, 20, 30};
 int W = 50;

 */
public class KnapSack {

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        Printer.printResult(knapSackMax(values, weights, W));
    }

    public static int knapSackMax(int[] values, int[] weights, int W) {

        int len = weights.length;

        // dp[i][j] represents the max subset of
        // first i items can reach given j
        int[][] dp = new int[len+1][W+1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= W; j++) {
                int value= values[i-1];
                int weight = weights[i-1];

                if (weight > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(value + dp[i-1][j-weight], dp[i-1][j]);
                }
            }
        }

        return dp[len][W];
    }
}
