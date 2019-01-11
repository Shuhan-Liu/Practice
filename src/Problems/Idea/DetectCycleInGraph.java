package Problems.Idea;

/**
 * Created by shuhanliu on 10/15/18.
 */
public class DetectCycleInGraph {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 0}, {0, 1}};
//        int[][] arr = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(detectCycle(5, arr));
    }

    public static boolean detectCycle(int n, int[][] arr) {

        int[] parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        for (int[] sub : arr) {
            int x = find(parent, sub[0]);
            int y = find(parent, sub[1]);

            // means a cycle is detected
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
        int xset = find(parent, x);
        int yset = find(parent, y);

        parent[xset] = yset;
    }
}
