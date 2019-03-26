package Problems.Onsite.dataStructure;

import java.util.*;

/**
 * Created by shuhanliu on 3/13/19.
 *
 * LC855 考试找位子，尽量分散坐，人会离开
 *
 * 思路：见leetcode
 *
 * 1.用优先队列：用优先队列存slot，slot包含左右端点和长度。exclusive好算。
 * 注意如果是最左或最右时长度为right - left，若非则为(right - left) / 2
 *
 * 2，因为如果选择坐边上可以不管端点。seat时候去pq最大slot，中间切开offer两段。
 * leave时候遍历找到左右两段整合
 */
public class ClassRoomTest {

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(4);
//        examRoom.printSeats();

        System.out.println(examRoom.seat());
//        examRoom.printSeats();

        System.out.println(examRoom.seat());
//        examRoom.printSeats();

        System.out.println(examRoom.seat());
//        examRoom.printSeats();

        System.out.println(examRoom.seat());
//        examRoom.printSeats();

        examRoom.leave(1);
//        examRoom.printSeats();

        examRoom.leave(3);
//        examRoom.printSeats();

        System.out.println(examRoom.seat());
//        examRoom.printSeats();
    }

    static class ExamRoom {

        PriorityQueue<Interval> pq;
        int N;

        class Interval {
            int s;
            int e;
            int dist;

            public Interval(int s, int e) {
                this.s = s;
                this.e = e;

                if (s == -1) {
                    this.dist = e;
                } else if (e == N) {
                    this.dist = N-s-1;
                } else {
                    this.dist = (e-s)/2;
                }
            }
        }

        public ExamRoom(int N) {
            this.N = N;
            pq = new PriorityQueue<>((a, b) -> a.dist != b.dist ? b.dist-a.dist : a.s-b.s);
            pq.offer(new Interval(-1, N));
        }

        public int seat() {
            Interval interval = pq.poll();
            int seat;
            if (interval.s == -1) {
                seat = 0;
            } else if (interval.e == N) {
                seat = N-1;
            } else {
                seat = (interval.s + interval.e)/2;
            }

            pq.offer(new Interval(interval.s, seat));
            pq.offer(new Interval(seat, interval.e));
            return seat;
        }

        public void leave(int p) {
            Interval first = null;
            Interval second = null;

            List<Interval> list = new ArrayList<>(pq);
            for (Interval inter : list) {
                if (inter.s == p) second = inter;
                else if (inter.e == p) first = inter;
            }

            pq.remove(first);
            pq.remove(second);

            pq.offer(new Interval(first.s, second.e));
        }
    }
}


/**
 * while (left < right && seats[left] == 0)
 left++;
 while (left < right && seats[right] == 0)
 right--;

 int maxDistance = left;
 int minIndex = left;
 int prevSeatedIndex = left;

 for (int i = left; i <= right; i++) {
 if (seats[i] == 1) {
 if ((i-prevSeatedIndex)/2-1 > maxDistance) {
 maxDistance = (i-prevSeatedIndex)/2-1;
 minIndex = prevSeatedIndex;
 }
 prevSeatedIndex = i;
 }
 }

 maxDistance = Math.max(maxDistance, Math.max(left, seats.length-1-right-1));

 if (maxDistance == left) {
 seats[0] = 1;
 count++;
 return 0;
 } else if (maxDistance == seats.length-1-right-1) {
 seats[seats.length-1] = 1;
 count++;
 return seats.length-1;
 } else {
 seats[minIndex + maxDistance+1] = 1;
 count++;
 return minIndex + maxDistance+1;
 }*/