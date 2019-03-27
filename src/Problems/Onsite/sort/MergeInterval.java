package Problems.Onsite.sort;

import Structure.Interval;
import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/14/19.
 *
 * LC 56
 *
 * Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

/**
 * Think together with meeting rooms II
 * */
public class MergeInterval {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        Collections.sort(intervals, (i1, i2) -> i1.start-i2.start);
        List<Interval> rtn = new ArrayList<>();
        Interval prev = intervals.get(0);
//        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i1.end - i2.end);
//        pq.offer(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if (cur.start <= prev.end) {
                prev.end = Math.max(cur.end, prev.end);
            } else {
                rtn.add(prev);
                prev = cur;
            }
        }

        rtn.add(prev);

        return rtn;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(2, 2));
        intervals.add(new Interval(3, 3));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(2, 2));
        intervals.add(new Interval(4, 6));

        Printer.printList(merge(intervals));
        Printer.printResult(mergeIntervalPracticeAgain(intervals));
    }

    public static List<Interval> mergeIntervalPracticeAgain(List<Interval> intervals) {

        if (intervals.size() <= 1)
            return intervals;

        List<Interval> list = new ArrayList<>();
        intervals.sort((i1, i2) -> i1.start - i2.start);

        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if (cur.start <= prev.end) {
                prev.end = Math.max(cur.end, prev.end);
            } else {
                list.add(prev);
                prev = cur;
            }
        }

        list.add(prev);

        return list;
    }
}
