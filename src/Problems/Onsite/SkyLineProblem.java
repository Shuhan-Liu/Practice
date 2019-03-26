package Problems.Onsite;

import Tool.Parser;
import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/14/19.
 *
 * LC 218
 * SKY LINE PROBLEM
 *
 */
public class SkyLineProblem {

    static class Point{
        int x;
        int y;
        int state;
        public Point(int x, int y, int state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }

        @Override
        public String toString() {
            return "X: " + this.x + " Y: " + this.y + " state: " + this.state;
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();

        if (buildings.length == 0)
            return result;

        List<Point> list = new ArrayList<>();

        for (int[] building : buildings) {
            list.add(new Point(building[0], building[2], 1));
            list.add(new Point(building[1], building[2], -1));
        }

        list.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p2.y - p1.y;
            }
            return p1.x - p2.x;
        });

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Point prev = list.get(0);
        int prevY = 0;
        treeMap.put(prev.y, treeMap.getOrDefault(prev.y, 0) + prev.state);

        for (int i = 1; i < list.size(); i++) {
            Point cur = list.get(i);
            System.out.println("PREVPOINT: " + prev);
            System.out.println("CURRPOINT: " + cur);
            if (cur.x > prev.x) {
                int y = findMaxY(treeMap);
                if (y != prevY) {
                    result.add(new int[]{prev.x, y});
                    prevY = y;
                }
            }
            prev = cur;
            treeMap.put(prev.y, treeMap.getOrDefault(prev.y, 0) + prev.state);
            printResult(result);
        }

        result.add(new int[]{prev.x, findMaxY(treeMap)});
        return result;
    }

    public static int findMaxY(TreeMap<Integer, Integer> treeMap) {

        Printer.printMap(treeMap);

        int max = 0;
        for (int key : treeMap.keySet()) {
            if (treeMap.get(key) > 0) {
                max = Math.max(max, key);
            }
        }
        return max;
    }



    public static void main(String[] args) {
        String s = "[[0,3,3],[1,5,3],[2,4,3],[3,7,3]]";
        int[][] buildings = Parser.parse2dArrayFromString(s);
        List<int[]> result = getSkyline(buildings);
        printResult(result);
    }

    public static void printResult(List<int[]> result) {
        System.out.print("RESULT: ");
        for (int[] point : result) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
        System.out.println();
    }
}
