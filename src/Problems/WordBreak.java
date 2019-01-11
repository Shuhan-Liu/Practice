package Problems;

import Tool.Printer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shuhanliu on 12/25/18.
 */
public class WordBreak {
    public static void main (String[] args) {
        String s = "leetcode";
        String[] arr = {"leet", "code"};
        Printer.printResult(wordBreak(s, Arrays.asList(arr)));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j, i))) {
                    // dp[j] here is dp[j-1+1]
                    if (j == 0 || dp[j])
                        dp[i] = true;
                }
            }
        }
        for (boolean b : dp) {
            System.out.print(b + " ");
        }
        System.out.println();
        return dp[n];
    }
}
