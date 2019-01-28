package Problems.Google;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/21/19.
 */
public class Maze {

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Set<String> visited = new HashSet<>();
        return hasPath(maze, start, destination, visited);
    }

    public static boolean hasPath(int[][] maze, int[] cur, int[] destination, Set<String> visited) {
        if (cur[0] < 0 || cur[0] >= maze.length || cur[1] < 0 || cur[1] >= maze[0].length)
            return false;
        if (maze[cur[0]][cur[1]] == 1)
            return false;
        if (cur[0] == destination[0] && cur[1] ==destination[1])
            return true;
        String curStr = cur[0] + "-" + cur[1];
        if (visited.contains(curStr))
            return false;
        visited.add(curStr);

        int[] arrTop = {cur[0]-1, cur[1]};
        int[] arrLeft = {cur[0], cur[1]-1};
        int[] arrDown = {cur[0]+1, cur[1]};
        int[] arrRight = {cur[0], cur[1]+1};

        if (hasPath(maze, arrTop, destination, visited))
            return true;
        if (hasPath(maze, arrLeft, destination, visited))
            return true;
        if (hasPath(maze, arrDown, destination, visited))
            return true;
        if (hasPath(maze, arrRight, destination, visited))
            return true;

        visited.remove(curStr);
        return false;
    }

    public static void main(String[] args) {

//        [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
//        [0,4]
//        [3,2]

        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};

        int[] start = {0, 4};
        int[] dest = {4, 4};

        Printer.printResult(hasPath(maze, start, dest));
    }
}
