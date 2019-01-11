package Problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuhanliu on 10/7/18.
 *
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 *
 * Idea: parse through 0 to n-1, for every user, do dfs, and use a hashset to store visited.
 */
public class FriendCircle {
    public static void main(String[] args) {
        int[][] M = {{1, 1, 0},
                     {1, 1, 0},
                     {0, 0, 1}};
        System.out.println(friendCircles(M));
    }

    public static int friendCircles(int[][] M) {
        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < M.length; i++) {
            if (!set.contains(i)) {
                set.add(i);
                dfs(M, set, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] M, Set<Integer> set, int i) {
        for (int j = 0; j < M.length; j++) {
            if (!set.contains(j) && M[i][j] == 1) {
                set.add(j);
                dfs(M, set, j);
            }
        }
    }
}
