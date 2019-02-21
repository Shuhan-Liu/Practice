package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/20/19.
 *
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

 Insert
 Remove
 Replace
 All of the above operations are of equal cost.

 Examples:

 Input:   str1 = "geek", str2 = "gesek"
 Output:  1
 We can convert str1 into str2 by inserting a 's'.

 Input:   str1 = "cat", str2 = "cut"
 Output:  1
 We can convert str1 into str2 by replacing 'a' with 'u'.

 Input:   str1 = "sunday", str2 = "saturday"
 Output:  3
 Last three and first characters are same.  We basically
 need to convert "un" to "atur".  This can be done using
 below three operations.
 Replace 'n' with 'r', insert t, insert a
 *
 */

public class EditDistance {

    public static void main(String[] args) {

//        String from = "geek";
//        String target = "gesek";

//        String from = "cat";
//        String target = "cut";

        String from = "sunday";
        String target = "saturday";

        Printer.printResult(editDistance(from, target));

    }

    public static int editDistance(String from, String target) {

        if (from == null || target == null)
            return -1;

        int len1 = from.length();
        int len2 = target.length();

        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;

        // dp[i][j] represents the editDistance
        // from from.subString(0, i) to target.subString(0, j)
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (from.charAt(i-1) == target.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, dp[i][j-1]); // insert
                    min = Math.min(min, dp[i-1][j]); // delete
                    min = Math.min(min, dp[i-1][j-1]); // edit

                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
