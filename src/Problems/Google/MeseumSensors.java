package Problems.Google;

import Tool.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuhanliu on 1/16/19.
 *
 * 有个很nb的宝物， 被放在一个展览馆的最深处， 通向这个宝物的一个通道里一堆感应器， 分布在展览馆的不同地方，
 * 每个感应器有不同的有效感应距离，
 * 问如何检测这些感应器能一定感应到进来行窃的贼。 需要从量化这个问题开始，自己设计整个函数
 */
public class MeseumSensors {

    static class Sensor{
        int x;
        int y;
        int r;
        public Sensor(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static class Edge{
        int from;
        int to;
        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main (String[] args) {
        Sensor s1 = new Sensor(2, 0, 1);
        Sensor s2 = new Sensor(2, 3, 3);
        Sensor s3 = new Sensor(1, 4, 1);
        Sensor s4 = new Sensor(3, 4, 1);
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(s1);
        sensors.add(s2);
        sensors.add(s3);
        sensors.add(s4);

        Printer.printResult(canDetect(sensors, -1, 5));
    }

    public static boolean canDetect(List<Sensor> sensors, int left, int right) {

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < sensors.size(); i++) {
            for (int j = i+1; j < sensors.size(); j++) {
                Sensor s1 = sensors.get(i);
                Sensor s2 = sensors.get(j);
                double dist = Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2);
                if (dist <= Math.pow(Math.max(s1.r, s2.r), 2)) {
                    edges.add(new Edge(i, j));
                }
            }
        }

        int[] parent = new int[sensors.size()];
        Arrays.fill(parent, -1);

        for (Edge edge : edges) {
            int x = find(parent, edge.from);
            int y = find(parent, edge.to);

            if (x != y)
                parent[y] = x;
        }

        Printer.printArr(parent);

        int count = 0;
        for (int i : parent) {
            if (i == -1)
                count++;
        }
        if (count > 1)
            return false;

        boolean leftWall = false;
        boolean rightWall = false;
        for (Sensor sensor : sensors) {
            if ((sensor.y - left) <= sensor.r)
                leftWall = true;
            if ((right - sensor.y) <= sensor.r)
                rightWall = true;
        }

        if (leftWall && rightWall)
            return true;

        return false;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == -1) {
            return x;
        }
        return find(parent, parent[x]);
    }
}
