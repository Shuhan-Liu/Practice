package Problems.Google;

import java.util.*;

/**
 * Created by shuhanliu on 1/6/19.
 */
public class Bicycle {

    static class Pair {
        int ped;
        int bike;
        public Pair(int ped, int bike) {
            this.ped = ped;
            this.bike = bike;
        }

        public String toString() {
            return "PED: " + ped + " BIKE: " + bike;
        }
    }

    static class Obj {
        Pair p;
        int dist;
        public Obj(Pair p, int dist) {
            this.p = p;
            this.dist = dist;
        }
    }

    public static void main (String[] args) {
//        OPOBOOP;
//        OOOOOOO;
//        OOOOOOO;
//        POOOOOO;
//        BOOBOOB;

        int[][] ped = {{0, 1}, {0, 6}, {3, 0}};
        int[][] bike = {{0, 3}, {4, 0}, {4, 3}, {4, 6}};
        List<Pair> ret = findMatch(ped, bike);
        for (Pair pair : ret) {
            System.out.println(pair.toString());
        }
    }

    public static List<Pair> findMatch(int[][] ped, int[][] bike) {

        List<Pair> ret = new ArrayList<>();

        PriorityQueue<Obj> queue = new PriorityQueue<>(new Comparator<Obj>(){
            @Override
            public int compare (Obj o1, Obj o2) {
                return o1.dist - o2.dist;
            }
        });
        for (int i = 0; i < ped.length; i++) {
            for (int j = 0; j < bike.length; j++) {
                Pair p = new Pair(i, j);
                int dist = Math.abs(ped[i][0] - bike[j][0]) + Math.abs(ped[i][1] - bike[j][1]);
                queue.offer(new Obj(p, dist));
            }
        }

        Set<Integer> visitedPed = new HashSet<>();
        Set<Integer> visitedBike = new HashSet<>();

        while (!queue.isEmpty() && visitedPed.size() < ped.length) {
            Obj obj = queue.poll();
            Pair p = obj.p;
            int dist = obj.dist;

            if (visitedPed.contains(p.ped) || visitedBike.contains(p.bike))
                continue;
            ret.add(p);
            visitedPed.add(p.ped);
            visitedBike.add(p.bike);
        }

        return ret;
    }
}
