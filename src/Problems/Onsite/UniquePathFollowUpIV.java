package Problems.Onsite;

import Tool.Printer;

/**
 * Created by shuhanliu on 3/9/19.
 * followup4: 给定一个下界
 (x == H)，找到能经过给定下界的所有从左上到右上的路径数量 (x >= H)
 思路：
 1：先dp一遍，得到所有到右上的路径数量
 2：然后在 0<=x<=H, 0<=y<=cols 这个小矩形中再DP一遍得到不经过下界的所有路径数量
 3：两个结果相减得到最终路径数量
 */
public class UniquePathFollowUpIV {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int H = 2;

        Printer.printResult(countPathsGivenBottomBorder(m, n, H));
    }

    public static int countPathsGivenBottomBorder(int rows, int cols, int H) {
        return countPath(rows, cols) - countPath(H, cols);
    }

    public static int countPath(int rows, int cols) {
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                dp[i][j] += dp[i][j-1];
                if (i-1 >= 0) dp[i][j] += dp[i-1][j-1];
                if (i+1 < rows) dp[i][j] += dp[i+1][j-1];
            }
        }
        return dp[rows-1][cols-1];
    }

}
