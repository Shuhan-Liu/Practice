package Problems.Onsite.sort;

import Structure.Interval;
import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/14/19.
 *
 * Given an array of meeting time intervals consisting of
 * start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoomsII {

    public static int minMeetingRooms(Interval[] intervals) {

        if (intervals.length < 2)
            return intervals.length;

        Arrays.sort(intervals, (i1, i2) -> i1.start-i2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2)->i1.end - i2.end);

        pq.offer(intervals[0]);
        int minRooms = 1;

        for (int i = 1; i < intervals.length; i++) {
            Interval earlist = pq.poll();
            Interval cur = intervals[i];

            if (earlist.end > cur.start) {
                pq.offer(cur);
                pq.offer(earlist);
            } else {
                pq.offer(cur);
            }

            minRooms = Math.max(minRooms, pq.size());
        }

        return minRooms;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
//        list.add(new Interval(2, 5));
//        list.add(new Interval(1, 5));
//        list.add(new Interval(1, 3));
//        list.add(new Interval(2, 5));
//        list.add(new Interval(3, 7));
//        list.add(new Interval(2, 6));
        list.add(new Interval(7, 10));
        list.add(new Interval(2, 4));

        Printer.printResult(minMeetingRooms(list.toArray(new Interval[list.size()])));
    }
}
