package Problems.Phone;

import Tool.Printer;

/**
 * Created by shuhanliu on 1/26/19.
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character
 Example 1:

 Input: word1 = "horse", word2 = "ros"
 Output: 3
 Explanation:
 horse -> rorse (replace 'h' with 'r')
 rorse -> rose (remove 'r')
 rose -> ros (remove 'e')
 Example 2:

 Input: word1 = "intention", word2 = "execution"
 Output: 5
 Explanation:
 intention -> inention (remove 't')
 inention -> enention (replace 'i' with 'e')
 enention -> exention (replace 'n' with 'x')
 exention -> exection (replace 'n' with 'c')
 exection -> execution (insert 'u')
 */
public class EditDistance {

    public static void main (String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        Printer.printResult(editDistance(s1, s2));

        String word1 = "a";
        String word2 = "ab";
        Printer.printResult(editDistance(word1, word2));
    }

    public static int editDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return -1;

        if (word1.equals(word2))
            return 0;

        int m = word1.length();
        int n = word2.length();

        if (m == 0)
            return n;
        if (n == 0)
            return m;

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // for insert, you've already match i chars in word1 to j-1 chars int word2
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }

        System.out.println("DP:");
        Printer.print2DArray(dp);

        return dp[m][n];
    }

}
