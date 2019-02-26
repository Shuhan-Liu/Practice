package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/25/19.
 *
 * Shortest Common Supersequence

 Given two strings str1 and str2, find the shortest string that
 has both str1 and str2 as subsequences.

 Examples :

 Input:   str1 = "geek",  str2 = "eke"
 Output: "geeke"

 Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
 Output:  "AGXGTXAYB"

 */
public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        Printer.printResult(shortestCommonSupersequence(s1, s2));
    }

    public static int shortestCommonSupersequence(String s1, String s2) {

        if (s1 == null || s2 == null)
            return 0;
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 == 0)
            return s2.length();
        if (len2 == 0)
            return s1.length();

        int lcs = LCS(s1, s2);

        return (len1 - lcs) + (len2 - lcs) + lcs;
    }

    public static int LCS(String s1, String s2) {

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
