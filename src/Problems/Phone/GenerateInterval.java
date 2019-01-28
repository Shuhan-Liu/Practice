package Problems.Phone;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/22/19.
 */
public class GenerateInterval {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            if (start == end) {
                return start+"";
            } else {
                return start + " : " + end;
            }
        }
    }

    public static void main (String[] args) {
        int len = 10;
        int maxVal = 20;
        int guessRounds = 5;
        Random rand = new Random();

        Set<Integer> set = new HashSet<>();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            int val = rand.nextInt(maxVal);
            while (set.contains(val)) {
                val = rand.nextInt(maxVal);
            }
            arr[i] = val;
            set.add(val);
        }
        Printer.printArr(arr);
        List<Interval> list = findIntervals(arr);

        int i = 1;
        while (i <= guessRounds) {
            int guess = rand.nextInt();
            System.out.println("contains " + guess + "? ");
            System.out.println(contains(list, guess));
            i++;
        }
    }

    public static List<Interval> findIntervals(int[] arr) {
        List<Interval> list = new ArrayList<>();
        if (arr.length == 0) {
            System.out.println("Empty");
            return list;
        }
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return list;
        }
        Arrays.sort(arr);
        Printer.printArr(arr);
        int start = arr[0];
        int end = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - end == 1) {
                end = arr[i];
            } else {
                list.add(new Interval(start, end));
                start = arr[i];
                end = arr[i];
            }
        }
        list.add(new Interval(start, end));
        for (Interval inter : list) {
            System.out.print(inter.toString() + ", ");
        }
        System.out.println();
        return list;
    }

    public static boolean contains(List<Interval> list, int target) {

        int left = 0;
        int right = list.size()-1;
        System.out.println("target: " + target);

        while (left <= right) {
            int mid = left + (right - left)/2;
            System.out.println("left:" + left + " mid:" + mid + " right:" + right);
            Interval inter = list.get(mid);
            if (inter.start <= target && target <= inter.end) {
                return true;
            } else if (inter.end < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= list.size())
            return false;
        Interval inter = list.get(left);
        if (inter.start <= target && target <= inter.end)
            return true;

        return false;
    }
}
