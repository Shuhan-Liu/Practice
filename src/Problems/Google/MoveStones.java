package Problems.Google;

import Tool.Parser;
import Tool.Printer;
import java.util.*;

/**
 * Created by shuhanliu on 2/5/19.
 *
 * On a 2D plane, we place stones at some integer coordinate points.
 * Each coordinate point may have at most one stone.
 * Now, a move consists of removing a stone that shares
 * a column or row with another stone on the grid.
 * What is the largest possible number of moves we can make?
 * Example 1:
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 *
 * Example 2:
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Example 3:
 *
 * Input: stones = [[0,0]]
 * Output: 0
 *
 */
public class MoveStones {
    static class Edge{
        int from;
        int to;
        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) {
        int[][] stones = Parser.parse2dArrayFromString("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]");
//        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
//        int[][] stones = Parser.parse2dArrayFromString("[[0,0],[0,2],[1,1],[2,0],[2,2]]");
        Printer.printResult(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {

        List<Edge> edges = new ArrayList<>();


        for (int i = 0; i < stones.length; i++) {
            int[] stoneOne = stones[i];
            for (int j = i + 1; j < stones.length; j++) {
                int[] stoneTwo = stones[j];
                if (stoneOne[0] == stoneTwo[0] || stoneOne[1] == stoneTwo[1]) {
                    edges.add(new Edge(i, j));
                }
            }
        }

        int[] parent = new int[stones.length];
        Arrays.fill(parent, -1);

//        int components = 0;
        int components = stones.length;

        for (Edge edge : edges) {
            int pFrom = find(parent, edge.from);
            int pTo = find(parent, edge.to);
            if (pTo != pFrom) {
                components--;
                parent[pTo] = pFrom;
            }
        }

//        for (int i : parent) {
//            if (i == -1)
//                components ++;
//        }

        return stones.length - components;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == -1)
            return x;
        return find(parent, parent[x]);
    }
}
