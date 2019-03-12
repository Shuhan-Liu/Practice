package Problems.Onsite;

import Tool.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhanliu on 3/9/19.
 *
 * followup2: 给定矩形里的三个点，判断是否存在遍历这三个点的路径
 * followup3: 给定矩形里的三个点，找到遍历这三个点的所有路径数量
 *
 */
public class UniquePathFollowIIAndIII {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int[][] points = {
                {0, 1},
                {1, 3},
                {2, 4}};

        boolean canReach = canReach(m, n, points);
        Printer.printResult(canReach);
        if (canReach) {
            Printer.printResult(countRoutes(m, n, points));
        }
    }

    public static boolean canReach(int m, int n, int[][] points) {

        List<int[]> list = new ArrayList<>();

        list.add(new int[2]);
        list.add(new int[]{0, n-1});
        for (int[] point : points) {
            list.add(point);
        }

        // Sort with Comparator, this is the lambda version
        list.sort((o1, o2) -> o1[1] - o2[1]);

        for (int i = 1; i < list.size(); i++) {
            int[] p1 = list.get(i-1);
            int[] p2 = list.get(i);

            if (!inTheShape(m, n, p1, p2))
                return false;
        }

        return true;

//        int[] first = points[0];
//        int[] second = points[1];
//        int[] third = points[2];
//
//        return inTheShape(first, second) && inTheShape(second, third);
    }

    public static boolean inTheShape(int m, int n, int[] p1, int[] p2) {

        if (p2[0] < 0 || p2[0] >= m || p2[1] < 0 || p2[1] >= n)
            return false;

        if (p2[1] <= p1[1])
            return false;

        float slope = ((float)Math.abs(p2[0] - p1[0])) / (p2[1] - p1[1]);

        if (slope > 1)
            return false;

        return true;
    }

    public static int countRoutes(int m, int n, int[][] points) {

        List<int[]> list = new ArrayList<>();
        list.add(new int[2]);
        list.add(new int[]{0, n-1});

        for (int[] point : points) {
            list.add(point);
        }

        list.sort((o1, o2) -> o1[1] - o2[1]);

        int routes = 1;

        for (int i = 1; i < list.size(); i++) {
            int[] p1 = list.get(i-1);
            int[] p2 = list.get(i);
            routes *= countRoutesBetweenTwoPoints(Math.abs(p1[0]-p2[0]), p2[1]-p1[1]);
        }


        return routes;
    }

    public static int countRoutesBetweenTwoPoints (int m, int n) {
        System.out.println("M, N : " + m + ", " + n);
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <= m; i++) {
                dp[i][j] += dp[i][j-1];
                if (i-1 >= 0)
                    dp[i][j] += dp[i-1][j-1];
                if (i+1 <= m)
                    dp[i][j] += dp[i+1][j-1];
            }
        }
        Printer.print2DArray(dp);
        System.out.println(dp[m][n]);
        return dp[m][n];
    }
}
