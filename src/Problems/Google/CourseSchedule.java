package Problems.Google;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/12/19.
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 Example 1:

 Input: 2, [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: 2, [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0, and to take course 0 you should
 also have finished course 1. So it is impossible.

 解法：判断有向图是否有环
 */
public class CourseSchedule {

    public static void main (String[] args) {

        int numCourses = 5;
        int[][] prerequisites = {{1, 0}, {1, 3}, {2, 1}, {2, 4}};

        Printer.printResult(canFinish(numCourses, prerequisites));

    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> visiting = new HashSet<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] require : prerequisites) {
            int from = require[1];
            int to = require[0];

            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        for (int i : map.keySet()) {
            if (hasCycleDFS(i, map, visited, visiting))
                return false;
        }
        return true;
    }

    public static boolean hasCycleDFS(int cur, Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> visiting) {
        if (visited.contains(cur))
            return false;
        if (visiting.contains(cur))
            return true;
        if (!map.containsKey(cur))
            return false;
        visiting.add(cur);
        for (int i : map.get(cur)) {
            if (hasCycleDFS(i, map, visited, visiting))
                return true;
        }
        visiting.remove(cur);
        visited.add(cur);
        return false;
    }
}
