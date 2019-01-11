package Problems.Google;

import Tool.Printer;

/**
 * Created by shuhanliu on 1/9/19.
 */
public class UniquePath {

    // Different from leetocde one, this will go from
    // left top to right top
    public static void main(String[] args) {
        int m = 5;
        int n = 4;
        Printer.printResult(countUniquePathsDP(m, n));
        Printer.printResult(countUniquePathsDFS(m, n));
        Printer.printResult(countUniquePathsON(m, n));
    }

    static int totalCount = 0;

    public static int countUniquePathsDFS(int m, int n) {

        dfs(0, 0, m, n, new int[m][n]);

        return totalCount;
    }

    public static void dfs(int i, int j, int m, int n, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;

        if (grid[i][j] == 1)
            return;

        if (i == 0 && j == n - 1) {
            totalCount++;
            return;
        }

        grid[i][j] = 1;
        dfs(i, j + 1, m, n, grid);
        dfs(i - 1, j + 1, m, n, grid);
        dfs(i + 1, j + 1, m, n, grid);
        grid[i][j] = 0;
    }

    public static int countUniquePathsDP(int m, int n) {

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (j - 1 >= 0)
                    dp[i][j] += dp[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0)
                    dp[i][j] += dp[i - 1][j - 1];
                if (i + 1 < m && j - 1 >= 0)
                    dp[i][j] += dp[i + 1][j - 1];
            }
        }

        return dp[0][n - 1];
    }

    // O(N)
    public static int countUniquePathsON(int m, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] dpPrev = new int[m];
        int[] dpCur = new int[m];

        dpPrev[0] = 1;

        int curIndex = 1;
        while (curIndex < n) {
            for (int i = 0; i < m; i++) {
                dpCur[i] += dpPrev[i];
                if (i - 1 >= 0)
                    dpCur[i] += dpPrev[i - 1];
                if (i + 1 < m)
                    dpCur[i] += dpPrev[i + 1];
            }

            for (int i = 0; i < m; i++) {
                dpPrev[i] = dpCur[i];
                dpCur[i] = 0;
            }
            curIndex++;
        }

        return dpPrev[0];
    }

}