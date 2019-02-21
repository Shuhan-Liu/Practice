package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/20/19.
 *
 * Longest Common Subsequence | DP-4

 We have discussed Overlapping Subproblems and Optimal Substructure properties
 in Set 1 and Set 2 respectively. We also discussed one example problem in Set 3.
 Let us discuss Longest Common Subsequence (LCS) problem as one more example problem
 that can be solved using Dynamic Programming.

 LCS Problem Statement: Given two sequences, find the length of longest subsequence
 present in both of them. A subsequence is a sequence that appears in the same relative
 order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, ..
 etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible
 subsequences.

 It is a classic computer science problem, the basis of diff (a file comparison program
 that outputs the differences between two files), and has applications in bioinformatics.

 Examples:
 LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

//        String s1 = "ABCDGH";
//        String s2 = "AEDFHR";

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        Printer.printResult(longestCommonSubsequence(s1, s2));

    }

    /*
    * input: two string s1, s2
    * output: int, represents the length of the longest common subsequence
    * */
    public static int longestCommonSubsequence(String s1, String s2) {

        if (s1 == null || s2 == null)
            return 0;

        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 == 0 || len2 == 0)
            return 0;

        // use dp[i][j] represent the length of the
        // longest subsequence of s1.substring(0, i)
        // and s2.substring(0, j)
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
