package Problems.Onsite;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/17/19.
 *
 * LC 750 Number Of Corner Rectangles
 *
 * Given a grid where each entry is only 0 or 1,
 * find the number of corner rectangles.
 *
 * A corner rectangle is 4 distinct 1s on the grid that
 * form an axis-aligned rectangle. Note that only the corners need to have the value 1.
 * Also, all four 1s used must be distinct.
 *
 *
 Example 1:

 Input: grid =
 [
 [1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
 Output: 1
 Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 */

/**
 * Thoughts: use dp, dp[j][k] means the number of existing line
 * from col j to col k.
 *
 * in the case of random, use a map to store value.
 * */
public class CornerRectangle {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}};

        Printer.printResult(countCornerRectangles(grid));

        int[][] randomGrid = {
                {7, 9, 6, 1, 7},
                {8, 1, 0, 2, 1},
                {7, 0, 1, 0, 7},
                {1, 1, 6, 1, 1},
                {5, 2, 9, 7, 1}};

        Printer.printResult(countCornerRectanglesRandomNumber(grid));
    }

    public static int countCornerRectanglesRandomNumber(int[][] grid) {

        if (grid.length < 2)
            return 0;

        int row = grid.length;
        int col = grid[0].length;

        Map<Integer, Integer>[][] dp = new Map[row][col];
        int rect = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                for (int k = j+1; k < col; k++) {

                    if (grid[i][j] == grid[i][k]) {
                        int num = grid[i][k];
                        if (dp[j][k] == null)
                            dp[j][k] = new HashMap<>();
                        Map<Integer, Integer> map = dp[j][k];

                        if (map.containsKey(num)) {
                            rect += map.get(num);
                            map.put(num, map.get(num)+1);
                        } else {
                            map.put(num, 1);
                        }
                    }
                }
            }
        }

        return rect;
    }

    public static int countCornerRectangles(int[][] grid) {
        if (grid.length < 2)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int rect = 0;

        // dp[x][y] represents the number of lines from
        // col x to col y.
        int[][] dp = new int[col][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {
                    for (int k = j+1; k < col; k++) {
                        if (grid[i][k] == 1) {
                            rect += dp[j][k];
                            dp[j][k] += 1;
                        }
                    }
                }

            }
        }

        return rect;
    }
}
