package Problems.Onsite;

import Tool.Parser;
import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/24/19.
 *
 * Correct Answer: See rectangleOO
 */
public class RectangleAreaII {
    static class Interval{
        int sx;
        int ex;
        int sy;
        int ey;

        public Interval(int sx, int ex, int sy, int ey) {
            this.sx = sx;
            this.ex = ex;
            this.sy = sy;
            this.ey = ey;
        }

        @Override
        public String toString() {
            return "sx: " + sx + " ex: " + ex + " sy: " + sy + " ey: " + ey;
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
        PriorityQueue<Interval> pq = new PriorityQueue<>((l1, l2) -> l1.sx - l2.sx);
        List<Interval> list = new ArrayList<>();

        for (int[] rect : rectangles) {
            pq.add(new Interval(rect[0], rect[2], rect[1], rect[3]));
        }


        Interval prev = pq.poll();
        while (!pq.isEmpty()) {
            Interval cur = pq.poll();

            System.out.println("PREV: " + prev);
            System.out.println("CURR: " + cur);

            if (prev.ex <= cur.sx){
                list.add(prev);
                prev = cur;
            } else if (prev.ey <= cur.sy || prev.sy >= cur.ey) {
                list.add(new Interval(prev.sx, cur.sx, prev.sy, prev.ey));
                prev.sx = cur.sx;
                pq.offer(prev);
                prev = cur;
            } else {
                Interval leftPart = new Interval(prev.sx, cur.sx, prev.sy, prev.ey);
                Interval overlap = null;
                Interval rightPart = null;
//                list.add(leftPart);

                if (prev.ex > cur.ex) {
                    rightPart = new Interval(cur.ex, prev.ex, prev.sy, prev.ey);
                    overlap = new Interval(cur.sx, cur.ex, Math.min(cur.sy, prev.sy), Math.max(cur.ey, prev.ey));
                } else {
                    rightPart = new Interval(prev.ex, cur.ex, cur.sy, cur.ey);
                    overlap = new Interval(cur.sx, prev.ex, Math.min(cur.sy, prev.sy), Math.max(cur.ey, prev.ey));
                }

                prev = leftPart;
                pq.offer(overlap);
                pq.offer(rightPart);

//                System.out.println("Left: " + leftPart);
//                System.out.println("Over: " + overlap);
//                System.out.println("Righ: " + rightPart);
            }
        }
        System.out.println();
        list.add(prev);
        int sum = 0;
        for (Interval inter : list) {
            System.out.println(inter);
            sum += (long)(inter.ex - inter.sx) * (inter.ey - inter.sy) % M;
            sum = sum % M;
        }
        return sum;
    }
}
