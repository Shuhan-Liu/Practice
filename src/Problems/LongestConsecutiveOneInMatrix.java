package Problems;

/**
 * Created by shuhanliu on 12/3/18.
 */
public class LongestConsecutiveOneInMatrix {

    public static void main (String[] args) {
        int[][] M = {{0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1}};
        System.out.println(longestLine(M));
    }

    public static int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0)
            return 0;
        int max = 0;
        int[] col = new int[M[0].length];
        int[] diag = new int[M.length + M[0].length];
        int[] anti = new int[M.length + M[0].length];

        for (int i = 0; i < M.length; i++) {
            int row = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    row += 1;
                    col[j] += 1;
                    diag[j - i + M.length] += 1;
                    anti[j + i] += 1;

                    max = Math.max(max, row);
                    max = Math.max(max, col[j]);
                    max = Math.max(max, diag[j - i + M.length]);
                    max = Math.max(max, anti[j + i]);
                } else {
                    row = 0;
                    col[j] = 0;
                    diag[j - i + M.length] = 0;
                    anti[j + i] = 0;
                }
            }
        }

        return max;
    }
}
