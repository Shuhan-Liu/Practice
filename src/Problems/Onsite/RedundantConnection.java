package Problems.Onsite;

import Tool.Parser;
import Tool.Printer;

import java.util.Arrays;

/**
 * Created by shuhanliu on 3/3/19.
 *
 * LC 684 Redundant Connection
 *
 * In this problem, a tree is an undirected graph that is
 * connected and has no cycles.

 The given input is a graph that started as a tree with N
 nodes (with distinct values 1, 2, ..., N), with one additional
 edge added. The added edge has two different vertices chosen
 from 1 to N, and was not an edge that already existed.

 The resulting graph is given as a 2D-array of edges.
 Each element of edges is a pair [u, v] with u < v, that represents
 an undirected edge connecting nodes u and v.

 Return an edge that can be removed so that the resulting
 graph is a tree of N nodes. If there are multiple answers,
 return the answer that occurs last in the given 2D-array.
 The answer edge [u, v] should be in the same format, with u < v.

 Example 1:

 Input: [[1,2], [1,3], [2,3]]
 Output: [2,3]
 Explanation: The given undirected graph will be like this:
     1
    / \
   2 - 3
 Example 2:

 Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 Output: [1,4]
 Explanation: The given undirected graph will be like this:
 5 - 1 - 2
     |   |
     4 - 3
 */
public class RedundantConnection {

    public static void main(String[] args) {
        String s = "[[1,2], [2,3], [3,4], [1,4], [1,5]]";
//        String s = "[[1,2], [1,3], [2,3]]";
        int[][] edges = Parser.parse2dArrayFromString(s);
        Printer.printArr(findRedundantConnection(edges));
        Printer.printArr(findRedundantConnectionII(edges));
    }

    public static int[] findRedundantConnectionII(int[][] edges) {
        int[] parent = new int[edges.length+1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int xParent = findWithPathCompression(parent, edge[0]);
            int yParent = findWithPathCompression(parent, edge[1]);

            if (xParent == yParent) {
                int[] rtn = {edge[0], edge[1]};
                return rtn;
            }

            parent[yParent] = xParent;
        }

        return new int[2];
    }


    public static int findWithPathCompression(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findWithPathCompression(parent, parent[x]);
        }
        return parent[x];
    }

    public static int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length+1];

        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int xParent = find(parent, edge[0]);
            int yParent = find(parent, edge[1]);

            if (xParent == yParent) {
                int[] rtn = {edge[0], edge[1]};
                return rtn;
            }

            parent[yParent] = xParent;
        }


        return new int[2];
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == -1)
            return x;
        return find(parent, parent[x]);
    }
}
