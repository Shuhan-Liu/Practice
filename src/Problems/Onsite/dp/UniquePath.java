package Problems.Onsite.dp;

import Tool.Printer;

/**
 * Created by shuhanliu on 3/3/19.
 *
 * LC 62. Unique Path
 *
 * A robot is located at the top-left corner of a
 * m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the
 grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 */
public class UniquePath {

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        Printer.printResult(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {

        if (m == 0)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-1 >= 0)
                    dp[i][j] += dp[i-1][j];
                if (j-1 >= 0)
                    dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
