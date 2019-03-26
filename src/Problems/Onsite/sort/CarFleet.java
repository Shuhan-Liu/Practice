package Problems.Onsite.sort;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/17/19.
 *
 * LC 853 Car Fleet
 *
 * N cars are going to the same destination along a one lane road.
 * The destination is target miles away.
 *
 * Each car i has a constant speed speed[i] (in miles per hour),
 * and initial position position[i] miles towards the target along the road.
 *
 * A car can never pass another car ahead of it, but it can catch up to it,
 * and drive bumper to bumper at the same speed.
 *
 * The distance between these two cars is ignored - they are assumed to have the same position.
 *
 * A car fleet is some non-empty set of cars driving at the same position and same speed.
 * Note that a single car is also a car fleet.
 *
 * If a car catches up to a car fleet right at the destination point,
 * it will still be considered as one car fleet.
 *
 *
 * How many car fleets will arrive at the destination?
 *
 */

/**
 * 思路：
 *
 * store with pq, and scan from closest to target to furthest from target.
 * merge two cars that will finally meet before target
 *
 * */
public class CarFleet {

    static class Car{
        int pos;
        int speed;
        float time;

        public Car(int pos, int speed, float time) {
            this.pos = pos;
            this.speed = speed;
            this.time = time;
        }

        @Override
        public String toString() {
            return "pos: " + pos + " speed: " + speed + " time: " + time;
        }
    }

    public static int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 0 || position.length != speed.length)
            return 0;

        PriorityQueue<Car> pq = new PriorityQueue<>((c1, c2) -> c2.pos - c1.pos);
        for (int i = 0; i < position.length; i++) {
            int pos = position[i];
            int spd = speed[i];
            float time = ((float)(target - pos)) / spd;

            pq.offer(new Car(pos, spd, time));
        }

        int fleet = 1;
        Car prev = pq.poll();

        while (!pq.isEmpty()) {

            Car cur = pq.poll();

            if (cur.time <= prev.time) {
                continue;
            } else if (cur.time > prev.time) {
                prev = cur;
                fleet++;
            }
        }

        return fleet;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        Printer.printResult(carFleet(target, position, speed));
    }
}
