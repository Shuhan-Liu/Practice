package Problems.Google;

import Tool.Parser;
import Tool.Printer;

import java.util.Arrays;

/**
 * Created by shuhanliu on 1/6/19.
 */
public class RedundantConnectionII {

    public static void main(String[] args) {
//        int[][] arr = {{1,2},{2,3},{3,4},{4,1},{1,5}};
        int[][] arr = {{2,1},{1,4},{4,2},{3,1}};
        int[] ret = findRedundantDirectedConnection(arr);
        System.out.println("edge to remove: ");
        Printer.printArr(ret);
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] cycleEdge = null;
        int[] mParent = null;

        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            System.out.println("x: " + x + " y: " + y);
            if (x == y)
                cycleEdge = edge;
            else {
                if (y != edge[1])
                    mParent = edge;
                else
                    parent[y] = x;
            }
        }

        /* print */
        Printer.printArr(parent);
        if (cycleEdge != null) {
            System.out.println("cycleEdge: ");
            Printer.printArr(cycleEdge);
        }
        if (mParent != null) {
            System.out.println("mParent: ");
            Printer.printArr(mParent);
        }
        /* print */

        // means we only got the multiparent problem, and the edges we recorded using parent so far are good, so juse return this one.
        if (cycleEdge == null)
            return mParent;

        // means we only got the cycle problem, in this case we can remove any edge in the cycle, so just remove this one.
        if (mParent == null)
            return cycleEdge;

        // now, it means we have both cycle and multi-parent problem.
        // In my code, i didn't record an edge into parent if we think it's involved into the multi-parent problem,
        // but we are still getting the cycle problem. Since in this problem we can only have to edges point to the same
        // node, so, current mParent edge is the wrong one, we need to remove the other one pointint to the same
        // dest as mParent
        for (int[] edge : edges) {
            if (edge[1] == mParent[1])
                return edge;
        }

        return new int[2];
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        return find(parent, parent[x]);
    }
}
