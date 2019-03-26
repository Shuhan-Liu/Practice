package Problems.Onsite;

import Tool.Parser;
import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/25/19.
 */
public class RectangleAreaOO {

    static class Point{
        int x;
        int y;
        int state;
        public Point(int x, int y, int state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }

    public static void main(String[] args) {
//        int[][] rectangles = {{22,24,67,34},{23,18,39,41},{10,63,80,98}};
//        int[][] rectangles = Parser.parse2dArrayFromString("[[2,58,59,89],[75,35,94,43],[21,3,92,62],[51,75,72,91]]");

        String s = "[[5,15,98,69],[39,16,79,78],[6,79,36,97],[14,4,27,31]]";
        int[][] rectangles = Parser.parse2dArrayFromString(s);

        Printer.printResult(rectangleArea(rectangles));
    }

    public static int rectangleArea(int[][] rectangles) {

        if (rectangles.length == 0)
            return 0;
        int M = 1000000007;

        List<Point> list = new ArrayList<>();

        for (int[] rect : rectangles) {
            list.add(new Point(rect[0], rect[1], 1));
            list.add(new Point(rect[0], rect[3], -1));
            list.add(new Point(rect[2], rect[1], -1));
            list.add(new Point(rect[2], rect[3], 1));
        }

        list.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p2.y - p1.y;
            }
            return p1.x - p2.x;
        });

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int area = 0;
        int prevX = -1;
        int prevY = -1;

        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            treeMap.put(p.y, treeMap.getOrDefault(p.y, 0) + p.state);

            if (i == list.size() - 1 || list.get(i+1).x > p.x) {
                if (prevX > -1) {
                    area += ((long)prevY * (p.x - prevX)) % M;
                    area %= M;
                }
                prevY = calY(treeMap);
                prevX = p.x;
            }
        }

//        Point prev = pq.poll();
//        PriorityQueue<Point> sameY = new PriorityQueue<>((p1, p2) -> p1.y - p2.y);
//        sameY.offer(prev);
//
//        while (!pq.isEmpty()) {
//            Point cur = pq.poll();
//            if (cur.x == prev.x) {
//                sameY.offer(cur);
//            } else {
//                area += (cur.x - prev.x) * calY(sameY);
//                sameY.offer(cur);
//                prev = cur;
//            }
//        }
//
//        area += ()

        return area;
    }

    public static int calY (TreeMap<Integer, Integer> treeMap) {
        int y = 0;
        int prev = -1;
        int count = 0;

        for (int key : treeMap.keySet()) {
            if (prev > -1 && count > 0) {
                y += key - prev;
            }
            count += treeMap.get(key);
            prev = key;
        }

        return y;
    }
}
