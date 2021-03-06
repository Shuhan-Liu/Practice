package Problems.Onsite.dp;

import Tool.Parser;
import Tool.Printer;

/**
 * Created by shuhanliu on 3/3/19.
 *
 * LC 63 Unique Path II
 *
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid
 (marked 'Finish' in the diagram below).

 Now consider if some obstacles are added to the grids.
 How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Input:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right
 */
public class UniquePathII {

    public static void main(String[] args) {

        String s = "[[0,0,0],[0,1,0],[0,0,0]]";
        int[][] obstacleGrid = Parser.parse2dArrayFromString(s);
        Printer.printResult(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                if (i-1 >= 0)
                    dp[i][j] += dp[i-1][j];
                if (j-1 >= 0)
                    dp[i][j] += dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
