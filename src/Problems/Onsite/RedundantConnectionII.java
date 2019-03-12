package Problems.Onsite;

import Tool.Parser;
import Tool.Printer;
import java.util.*;

/**
 * Created by shuhanliu on 3/3/19.
 *
 * LC 685 Redundant Connection II
 *
 * In this problem, a rooted tree is a directed graph such that,
 * there is exactly one node (the root) for which all other nodes
 * are descendants of this node, plus every node has exactly one parent,
 * except for the root node which has no parents.

 The given input is a directed graph that started as a rooted tree with
 N nodes (with distinct values 1, 2, ..., N), with one additional directed
 edge added. The added edge has two different vertices chosen from 1 to N,
 and was not an edge that already existed.

 The resulting graph is given as a 2D-array of edges. Each element of edges
 is a pair [u, v] that represents a directed edge connecting nodes u and v,
 where u is a parent of child v.

 Return an edge that can be removed so that the resulting graph is a rooted
 tree of N nodes. If there are multiple answers, return the answer that occurs
 last in the given 2D-array.

 Example 1:

 Input: [[1,2], [1,3], [2,3]]
 Output: [2,3]
 Explanation: The given directed graph will be like this:
    1
   / \
  v   v
  2-->3
 Example 2:

 Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 Output: [4,1]
 Explanation: The given directed graph will be like this:
 5 <- 1 -> 2
      ^    |
      |    v
      4 <- 3
 */
public class RedundantConnectionII {

    public static void main(String[] args) {
//        String s = "[[1,2], [2,3], [3,4], [4,1], [1,5]]";
//        String s = "[[1,2],[1,3],[2,3]]";
//        String s = "[[1,2],[3,1],[2,3]]";
//        String s = "[[2,1],[3,1],[4,2],[1,4]]";
        String s = "[[1,2],[2,3],[4,1],[3,1]]";

        int[][] edges = Parser.parse2dArrayFromString(s);
        Printer.printArr(findRedundantDirectedConnection(edges));
    }

    // why this is different than just detecting cycles in directed graph?
    // because it requires the result after removing the redundant edge
    // to be a tree. think about example: "[[2,1],[3,1],[4,2],[1,4]]"
    // you cannot remove any edge that causes the loop
    public static int[] findRedundantDirectedConnection(int[][] edges) {

        Map<Integer, int[]> map = new HashMap<>();

        // if there's a vertex with in-degree equal to 2
        // we store the first and second edge of it.
        int[] firstEdge = null;
        int[] secondEdge = null;

        for (int[] edge : edges) {
            if(map.containsKey(edge[1])) {
                firstEdge = map.get(edge[1]);
                secondEdge = edge;
            } else {
                map.put(edge[1], edge);
            }
        }

        int[] parent = new int[edges.length+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // treat it as undirected graph
        for (int[] edge : edges) {

            // if second edge is not null, let's assume we've already remove second edge
            if (secondEdge != null && edge[0] == secondEdge[0] && edge[1] == secondEdge[1])
                continue;

            int xParent = findWithPathCompression(parent, edge[0]);
            int yParent = findWithPathCompression(parent, edge[1]);

            // when there's still a loop:
            // if there's no edge with an in-degree equal 2,
            // return the edge cause the loop
            // if there is, return the first edge bacuase we've already remove the second edge
            if (xParent == yParent) {
                if (firstEdge == null) {
                    return edge;
                } else {
                    return firstEdge;
                }
            } else {
                parent[yParent] = xParent;
            }
        }

        // if no error occurs again, it means we remove them correctly
        return secondEdge;
    }

    public static int findWithPathCompression(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findWithPathCompression(parent, parent[x]);
        }

        return parent[x];
    }
}
