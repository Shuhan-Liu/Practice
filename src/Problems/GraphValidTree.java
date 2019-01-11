package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuhanliu on 10/15/18.
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};

        System.out.println(validTree(n, edges));
        System.out.println(validTreeDfs(n, edges));
    }

    public static boolean validTreeDfs(int n, int[][] edges) {
        if (edges.length != n-1)
            return false;

        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];

            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        boolean[] visited = new boolean[n];
        if (hasCycle(-1, 0, adj, visited))
            return false;

        for (boolean bool : visited)
            if (!bool)
                return false;

        return true;
    }

    public static boolean hasCycle(int parent, int curr, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;

        for (int i : adj.get(curr)) {
            if (visited[i]) {
                if (i != parent)
                    return true;
            } else {
                if (hasCycle(curr, i, adj, visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean validTree(int n, int[][] edges) {

        if (edges.length != n-1)
            return false;

        return !hasCycle(n, edges);
    }

    public static boolean hasCycle(int n, int[][] edges) {

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            if (x == y)
                return true;

            union(x, y, parent);
        }

        return false;
    }

    public static int find(int[] parent, int target) {
        if (parent[target] == -1)
            return target;

        return find(parent, parent[target]);
    }

    public static void union(int x, int y, int[] parent) {
//        int xset = find(parent, x);
//        int yset = find(parent, y);

        parent[x] = y;
    }

}
