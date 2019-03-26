package Problems.Onsite.dp;

import Tool.Printer;
import java.util.*;

/**
 * Created by shuhanliu on 3/11/19.
 *
 * Given a N*N matrix with random amount of money in each cell,
 * you start from top-left, and can only move from left to right,
 * or top to bottom one step at a time until you hit the bottom right cell.
 * Find the path with max amount of money on its way.
 Sample data:
 start
 |
 v
 5,   15,20,  ...
 10, 15,  5,   ...
 30,  5,  5,    ...
 …
                ^end here.
 思路：LC 64 最小路径和，思路差不多，只是求和变成求相加后的最大值
 *
 */
public class UniquePathTransform {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 0, 20},
                {0, 0, 5},
                {30, 5, 5}};

        Printer.printResult(maxMoneyOnPath(matrix));
        Printer.printList(maxMoneyOnPathWithPath(matrix));
        Printer.printList(maxMoneyOnPathWithPathO1Space(matrix));
    }

    public static int maxMoneyOnPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] maxMoney = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int max = 0;
                if (i-1 >= 0) {
                    max = Math.max(max, maxMoney[i-1][j]);
                }

                if (j-1 >= 0) {
                    max = Math.max(max, maxMoney[i][j-1]);
                }

                maxMoney[i][j] = matrix[i][j] + max;
            }
        }
        return maxMoney[matrix.length-1][matrix[0].length-1];
    }

    public static List<String> maxMoneyOnPathWithPath(int[][] matrix) {

        List<String> rtn = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0)
            return rtn;

        int[][] maxMoney = new int[matrix.length][matrix[0].length];
        char[][] directions = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int max = 0;
                char direction = 'o';

                if (i-1 >= 0 && maxMoney[i-1][j] >= max) {
                    max = maxMoney[i-1][j];
                    direction = 'b';
                }

                if (j-1 >= 0 && maxMoney[i][j-1] >= max) {
                    max = maxMoney[i][j-1];
                    direction = 'r';
                }

                maxMoney[i][j] = matrix[i][j] + max;
                directions[i][j] = direction;
            }
        }

        int i = matrix.length-1;
        int j = matrix[0].length-1;
        while (i >= 0 && j >= 0) {
            char dir = directions[i][j];
            rtn.add("("+i+", "+j+")");

            if (dir == 'r') {
                j = j-1;
            } else if (dir =='b') {
                i = i-1;
            } else {
                break;
            }
        }

        Collections.reverse(rtn);

        return rtn;
    }

    public static List<String> maxMoneyOnPathWithPathO1Space(int[][] matrix) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int max = 0;
                int flag = -1;
                if (i-1>=0) {
                    max = Math.max(max, Math.abs(matrix[i-1][j]));
                    flag = -1;
                }

                if (j-1>=0) {
                    max = Math.max(max, Math.abs(matrix[i][j-1]));
                    flag = 1;
                }

                matrix[i][j] += max;
                matrix[i][j] *= flag;
            }
        }

        int i = matrix.length-1;
        int j = matrix[0].length-1;

        while (i>=0 && j>=0) {
            list.add("("+i+", "+j+")");

            if (matrix[i][j] < 0) {
                i--;
            } else if (matrix[i][j] > 0){
                j--;
            } else {
                if (j-1 >= 0)
                    j--;
                else
                    i--;
            }
        }
        Collections.reverse(list);
        return list;
    }
}
