package Problems;

import java.util.Arrays;

/**
 * Created by shuhanliu on 12/26/18.
 */
public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        // number of vertices
        int n = 6;
        int[][] edges = {{0, 1}, {1, 2}, {3, 5}, {2, 3}, {3, 0}};
        System.out.println(hasCycle(n, edges));
    }

    // using union find
    // If m operations, either Union or Find, are applied to n elements, the total run time is O(m log*n)
    public static boolean hasCycle(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int x = find(edge[0], parent);
            int y = find(edge[1], parent);

            if (x == y)
                return true;

            parent[y] = x;
        }
        return false;
    }

    public static int find(int x, int[] parent) {
        if (parent[x] != -1)
            return find(parent[x], parent);
        return x;
    }
}
