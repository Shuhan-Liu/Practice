package Problems.Google;

import Tool.Parser;
import Tool.Printer;

/**
 * Created by shuhanliu on 2/5/19.
 *
 * Code below is a test on solving problem in MoveStones.java
 * using optimized union find solution:
 *
 * Union find with rank and path compression
 *
 * Let's start
 */
public class MoveStonesUFWIthRankPathCompression {

    static class UnionFind{

        int[] parent;
        int[] rank;
        int n;
        int count;

        UnionFind (int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            this.n = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find (int x) {
            if (parent[x] != x) {
                // Path compression:
                // find the root of the x
                // and assign the root to parent[x]
                // to compress the path
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);

            if (xp != yp) {
                // Rank:
                // when doing union
                // always attach the tree
                // with lower height to the
                // tree with higher height
                if (rank[xp] > rank[yp]) {
                    parent[yp] = xp;
                } else if (rank[xp] < rank[yp]) {
                    parent[xp] = yp;
                } else {
                    parent[xp] = yp;
                    rank[yp] += 1;
                }
                count--;
            }
        }

        int getConnectedComponentsCount() {
            return count;
        }
    }

    public static void main (String[] args) {
        String input = "[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]";
//        String input = "[[0,0],[0,2],[1,1],[2,0],[2,2]]";
//        String input = "[[0,0]]";
        int[][] stones = Parser.parse2dArrayFromString(input);
        Printer.printResult(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones.length);
        for (int i = 0; i < stones.length; i++) {
            int[] stone1 = stones[i];
            for (int j = i+1; j < stones.length; j++) {
                int[] stone2 = stones[j];
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    uf.union(i, j);
                }
            }
        }
        return stones.length - uf.getConnectedComponentsCount();
    }
}
