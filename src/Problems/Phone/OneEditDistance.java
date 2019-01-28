package Problems.Phone;

import Tool.Printer;

/**
 * Created by shuhanliu on 1/26/19.
 *
 * Given two strings s and t, determine if they are both one edit distance apart.

 Note:

 There are 3 possiblities to satisify one edit distance apart:

 Insert a character into s to get t
 Delete a character from s to get t
 Replace a character of s to get t
 Example 1:

 Input: s = "ab", t = "acb"
 Output: true
 Explanation: We can insert 'c' into s to get t.
 Example 2:

 Input: s = "cab", t = "ad"
 Output: false
 Explanation: We cannot get t from s by only one step.
 Example 3:

 Input: s = "1203", t = "1213"
 Output: true
 Explanation: We can replace '0' with '1' to get t.

 *
 */
public class OneEditDistance {

    public static void main(String[] args) {
        String word1 = "1203";
        String word2 = "1213";

        Printer.printResult(isOneEditDistance(word1, word2));
    }

    public static boolean isOneEditDistance(String word1, String word2) {
        if (word1 == null || word2 == null || word1.equals(word2))
            return false;

        int m = word1.length();
        int n = word2.length();

        if (Math.abs(m - n) > 1)
            return false;

        int len = Math.min(m, n);

        for (int i = 0; i < len; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (c1 != c2) {
                if (i+1 < n && word1.substring(i).equals(word2.substring(i+1)))
                    return true;
                if (i+1 < m && word1.substring(i+1).equals(word2.substring(i)))
                    return true;
                if (i+1 < m && i+1 < n && word1.substring(i+1).equals(word2.substring(i+1)))
                    return true;
                if (i == m-1 && i == n-1)
                    return true;
                return false;
            }
        }

        return true;
    }
}
