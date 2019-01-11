package Problems;

import Tool.Common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuhanliu on 12/15/18.
 */
public class MovingStones {

    public static void main (String[] args) {
        int[][] stones = {{0,1},{1,0},{1,1}};
        System.out.println(removeStonesNaive(stones));
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int len = stones.length;
        int components = len;
        int[] parent = new int[len];
        Arrays.fill(parent, -1);
        for (int i = 0; i < len; i++) {
            int[] s1 = stones[i];
            for (int j = i+1; j < len; j++) {
                int[] s2 = stones[j];
                if (s1[0] == s2[0] || s1[1] == s2[1]) {
                    int x = find(i, parent);
                    int y = find(j, parent);

                    if (x != y) {
                        components--;
                        parent[y] = x;
                    }
                }
            }
        }
        return len - components;
    }

    public static int find(int x, int[] parent) {
        if (parent[x] == -1)
            return x;
        return find(parent[x], parent);
    }

    public static int removeStonesNaive(int[][] stones) {
        int components = stones.length;
        Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> colMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            int row = stone[0];
            int col = stone[1];
            int sameRow = -1;
            int sameCol = -1;

            if (rowMap.containsKey(row)) {
                sameRow = rowMap.get(row);
            }
            if (colMap.containsKey(col)) {
                sameCol = colMap.get(col);
            }

            if (sameRow != -1)
                components--;

            if (sameCol != -1)
                components--;

            rowMap.put(row, i);
            colMap.put(col, i);

//            System.out.println("row: " + row + " col: " + col);
//            System.out.println("sameRow: " + sameRow + " sameCol: " + sameCol);
//            System.out.println("rowMap: ");
//            Common.printHashMap(rowMap);
//            System.out.println("colMap: ");
//            Common.printHashMap(colMap);
//            System.out.println("Number of Components:" + components);
//            System.out.println();
        }

        return stones.length - components;
    }
}
