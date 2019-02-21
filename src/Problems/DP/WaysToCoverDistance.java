package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/20/19.
 *
 * Given a distance ‘dist, count total number of
 * ways to cover the distance with 1,
 * 2 and 3 steps.

 Examples :

 Input:  n = 3
 Output: 4
 Below are the four ways
 1 step + 1 step + 1 step
 1 step + 2 step
 2 step + 1 step
 3 step

 Input:  n = 4
 Output: 7
 *
 */
public class WaysToCoverDistance {

    public static void main(String[] args) {
        int n = 3;
        Printer.printResult(waysToCoverDistance(n));
    }

    public static int waysToCoverDistance(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int[] ways = new int[n+1];
        ways[0] = 1;                // Importat, not 0
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
        }

        for (int x : ways)
            System.out.print(x);
        System.out.println();
        return ways[n];
    }
}
