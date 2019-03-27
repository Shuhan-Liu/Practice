package Problems.Onsite.sort;

import Structure.Interval;
import Tool.Printer;
import Tool.Unit;

import java.util.*;

/**
 * Created by shuhanliu on 3/23/19.
 *
 * LC 253
 *
 * [[0, 30],[5, 10],[15, 20]]
 */



public class MinMeetingRooms {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        [[0, 30],[5, 10],[15, 20]]
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        Interval[] arr = new Interval[intervals.size()];

        intervals.toArray(arr);

        Printer.printResult(minMeetingRooms(arr));
        Printer.printResult(minMeetingRoomsRegular(arr));
    }

    public static int minMeetingRoomsRegular(Interval[] intervals) {

        Long curTime = System.currentTimeMillis();

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i1.end - i2.end);
        pq.offer(intervals[0]);
        int maxRoom = 1;

        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (pq.isEmpty()) {
                pq.offer(cur);
            } else {
                if (pq.peek().end > cur.start) {
                    pq.offer(cur);
                    maxRoom = Math.max(maxRoom, pq.size());
                } else {
                    pq.poll();
                    pq.offer(cur);
                }
            }
        }

        Printer.printTimeUsed(curTime, System.currentTimeMillis(), Unit.MILLISECONDS);

        return maxRoom;
    }

    public static int minMeetingRooms(Interval[] intervals) {
        Long curTime = System.currentTimeMillis();

        int count = 0;
        if (intervals.length == 0)
            return count;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        count = 1;
        int endIndex = 0;

        for (int i = 1; i < start.length; i++) {
            if (start[i] >= end[endIndex]) {
                endIndex++;
            } else {
                count++;
            }
        }

        Printer.printTimeUsed(curTime, System.currentTimeMillis(), Unit.MILLISECONDS);

        return count;
    }
}
