package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/21/19.\
 *
 * Problem statement: Consider a row of n coins of values v1 . . . vn,
 * where n is even. We play a game against an opponent by alternating turns.
 * In each turn, a player selects either the first or last coin from the row,
 * removes it from the row permanently, and receives the value of the coin.
 * Determine the maximum possible amount of money we can definitely win if we move first.
 *
 *  1. 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)

 2. 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)

 Does choosing the best at each move give an optimal solution?

 No. In the second example, this is how the game can finish:

 1.
 …….User chooses 8.
 …….Opponent chooses 15.
 …….User chooses 7.
 …….Opponent chooses 3.
 Total value collected by user is 15(8 + 7)
 2.
 …….User chooses 7.
 …….Opponent chooses 8.
 …….User chooses 15.
 …….Opponent chooses 3.
 Total value collected by user is 22(7 + 15)
 So if the user follows the second game state, maximum value can be
 collected although the first move is not the best.



 Note: The opponent is as clever as the user.
 */
public class OptimalStrategyForAGame {

    public static void main(String[] args) {
//        int[] arr = {5, 3, 7, 10};
        int[] arr = {8, 15, 3, 7};
        Printer.printResult(maxAmount(arr));
    }

    public static int maxAmount(int[] arr) {

        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int x = i+2 <= j ? dp[i+2][j] : 0;
                int y = i+1 <= j-1 ? dp[i+1][j-1] : 0;
                int z = i <= j-2 ? dp[i][j-2] : 0;

                int pickI = arr[i] + Math.min(x, y);
                int pickJ = arr[j] + Math.min(y, z);

                dp[i][j] = Math.max(pickI, pickJ);
            }
        }

        return dp[0][n-1];
    }
}
