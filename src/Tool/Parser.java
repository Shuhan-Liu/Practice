package Tool;

import java.util.*;

/**
 * Created by shuhanliu on 1/6/19.
 */
public class Parser {
    public static int[][] parse2dArrayFromString(String s) {

        String tmp = s.substring(2, s.length()-2);
        String[] arr = tmp.split("\\],\\[");
        int m = arr.length;
        int n = arr[0].split(",").length;
        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            String row = arr[i];
            String[] rowArr = row.split(",");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(rowArr[j]);
            }
        }

//        for(int[] row : nums) {
//            System.out.print("{ ");
//            for (int item : row) {
//                System.out.print(item + " ");
//            }
//            System.out.println("}");
//        }

        return nums;
    }
}
