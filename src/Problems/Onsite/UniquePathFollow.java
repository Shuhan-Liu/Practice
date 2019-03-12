package Problems.Onsite;

import Tool.Printer;

/**
 * Created by shuhanliu on 3/4/19.
 *
 * This is the follow up of Unique Path.
 * Rules：
 1. 从左上角走到右上角
 2. 机器人只能走右上，右和右下
 */
public class UniquePathFollow {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        Printer.printResult(uniquePathFollowUp(m, n));
        Printer.printResult(uniquePathSaveSpace(m, n));
    }

    public static int uniquePathFollowUp(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (j-1 >= 0) {
                    dp[i][j] += dp[i][j-1];

                    if (i-1 >= 0) {
                        dp[i][j] += dp[i-1][j-1];
                    }

                    if (i+1 < m) {
                        dp[i][j] += dp[i+1][j-1];
                    }
                }
            }
        }

        return dp[0][n-1];
    }

    public static int uniquePathSaveSpace(int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        int[] dp = new int[m];
        int[] tmp = new int[m];

        dp[0] = 1;

        for (int j = 1; j < n; j++) {

            for (int i = 0; i < m; i++) {
                int val1 = i-1 >= 0 ? dp[i-1] : 0;
                int val2 = dp[i];
                int val3 = i+1 < m  ? dp[i+1] : 0;

                // Note, tmp[i] may not eaual to 0 before assign
                tmp[i] = val1 + val2 + val3;
            }

            // Important
            System.arraycopy(tmp, 0, dp, 0, m);
        }

        return dp[0];
    }
}
