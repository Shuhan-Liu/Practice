package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/25/19.
 *
 * Given a rod of length n inches and an array of prices that contains
 * prices of all pieces of size smaller than n. Determine the maximum
 * value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different
 * pieces are given as following, then the maximum obtainable value
 * is 22 (by cutting in two pieces of lengths 2 and 6)
 *


 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 1   5   8   9  10  17  17  20
 And if the prices are as following, then the maximum obtainable
 value is 24 (by cutting in eight pieces of length 1)

 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 3   5   8   9  10  17  17  20


 */
public class RodCutting {

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        Printer.printResult(rodCutting(price, n));

    }

    public static int rodCutting(int[] price, int n) {

        // dp[i] represents the max you
        // can achieve given prices with length i
        int[] dp = new int[n+1];

        dp[1] = price[0];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(price[j-1] + dp[i-j], dp[i]);
            }
        }

        return dp[n];
    }
}
