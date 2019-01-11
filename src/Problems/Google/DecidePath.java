package Problems.Google;

import Tool.Printer;

/**
 * Created by shuhanliu on 1/9/19.
 */
public class DecidePath {

    // give 3 points in a matrix, decide whether
    // there exists a path connects all three points
    // allows direction right, right-up, right-bot
    public static void main (String[] args) {
        int m = 5;
        int n = 5;
        int[][] points = {{0,2}, {3,3}, {2,3}};

        Printer.printResult(hasPath(points, m, n));
    }

    public static boolean hasPath(int[][] points, int m, int n) {

        return false;
    }
}
