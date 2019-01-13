package Problems.CommonTechniques;

import java.util.*;

/**
 * Created by shuhanliu on 1/12/19.
 */
public class DetectCycleInDirectedGraph {
    public static void main (String[] args) {
//        int[][] edges = {{0,1}, {1,2}, {0,2}};
        int[][] edges = {{0,1}, {6,2}, {7,1}, {4,6}, {0,7}, {5,0}, {1,5}};
        System.out.println(hasCycle(edges));
    }

    // dfs with topological sort
    // time complexity: O(V+E) since every edge and vertex is visited once.
    public static boolean hasCycle(int[][] edges) {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        // construct graph from edges
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }
            map.get(start).add(end);
        }

        for (int key : map.keySet()) {
            if (dfs(map, key, visited, visiting))
                return true;
        }

        return false;
    }

    public static boolean dfs(Map<Integer, List<Integer>> map, int key, Set<Integer> visited, Set<Integer> visiting) {
        if (visited.contains(key))
            return false;
        if (visiting.contains(key))
            return true;

        visiting.add(key);
        if (map.containsKey(key)) {
            for (int newNode : map.get(key)) {
                if (dfs(map, newNode, visited, visiting))
                    return true;
            }
        }
        visiting.remove(key);
        visited.add(key);
        return false;
    }
}
