package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/20/19.
 *
 * Given a set of non-negative integers, and a value sum, determine
 * if there is a subset of the given set with sum equal to given sum.
 Example:

 Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 Output:  True  //There is a subset (4, 5) with sum 9.

 */
public class SubsetSum {

    public static void main(String[] args) {

        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 15;

        Printer.printResult(subSetSum(set, sum));
    }

    public static boolean subSetSum(int[] set, int sum) {

        if (set.length == 0)
            return false;

        int len = set.length;

        // dp[i][j] represents first i numbers in
        // set's ability to sum to j
        boolean[][] dp = new boolean[len+1][sum+1];

        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {

                if (dp[i-1][j])
                    dp[i][j] = true;

                if (j >= set[i-1] && dp[i-1][j-set[i-1]]) {
                    dp[i][j] = true;
                }
            }
        }

//        Printer.print2DArray(dp);

        for (boolean[] row : dp) {
            for (boolean cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

        return dp[len][sum];
    }
}
