package Problems.Onsite.sort;

import Structure.Interval;
import Tool.Printer;
import Tool.Unit;

import java.util.*;

/**
 * Created by shuhanliu on 3/23/19.
 */
public class DetectIntervalIdle {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(0, 30));
//        intervals.add(new Interval(5, 10));
//        intervals.add(new Interval(15, 20));
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(18, 20));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Interval inter : intervals) {
            min = Math.min(min, inter.start);
            max = Math.max(max, inter.end);
        }

        Interval[] arr = new Interval[intervals.size()];
        intervals.toArray(arr);

        Interval[] arr2 = new Interval[intervals.size()];
        intervals.toArray(arr2);

        Random rand = new Random();
        int time = rand.nextInt(max + 10) - 5;
        System.out.println("Target time point: " + time);

        Printer.printResult(isIdle(time, arr));
        Printer.printResult(isIdleBinary(time, arr2));
    }

    public static boolean isIdleBinary(int time, Interval[] intervals) {

        Long curTime = System.currentTimeMillis();

        List<Interval> mergedIntervals = mergeIntervals(intervals);

        int left = 0;
        int right = mergedIntervals.size()-1;

        boolean isIdle = true;

        while (left <= right) {
            int mid = left + (right - left)/2;

            Interval inter = mergedIntervals.get(mid);

            if (time <= inter.end && time >= inter.start) {
                isIdle = false;
                break;
            } else if (time > inter.end) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        Printer.printTimeUsed(curTime, System.currentTimeMillis(), Unit.MILLISECONDS);

        return isIdle;
    }

    public static boolean isIdle(int time, Interval[] intervals) {

        Long curTime = System.currentTimeMillis();

        List<Interval> mergedIntervals = mergeIntervals(intervals);

        boolean isIdle = true;

        for (Interval inter : mergedIntervals) {
            System.out.print(inter + " ");

            if (time <= inter.end && time >= inter.start) {
                isIdle = false;
            }
        }
        System.out.println();

        Printer.printTimeUsed(curTime, System.currentTimeMillis(), Unit.MILLISECONDS);

        return isIdle;
    }

    public static List<Interval> mergeIntervals (Interval[] intervals) {
        List<Interval> list = new ArrayList<>();

        if (intervals.length == 0)
            return list;

        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        Interval prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];

            if (cur.start <= prev.end) {
                prev.end = Math.max(prev.end, cur.end);
            } else {
                list.add(prev);
                prev = cur;
            }
        }

        list.add(prev);

        return list;
    }

    // [1,10],[2,4],[9,20]
}
