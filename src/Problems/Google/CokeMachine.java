package Problems.Google;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/20/19.
 */
public class CokeMachine {

    static class Soda{
        public int min;
        public int max;

        public Soda(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static boolean canGetDFS(List<Soda> sodas, int tMin, int tMax) {
        boolean canGet = false;
        for (Soda soda : sodas) {
            if (soda.min >= tMin && soda.max <= tMax) {
                return true;
            } else if (soda.min < tMin && soda.max < tMax) {
                canGet = canGetDFS(sodas, tMin - soda.min, tMax - soda.max);
                if (canGet)
                    break;
            }
        }

        return canGet;
    }

    public static boolean canGetDP(List<Soda> sodas, int tMin, int tMax) {

//        int[][] dp = new int[tMin][tMax];
        boolean[] dp = new boolean[tMax];

        for (Soda soda : sodas) {
            for (int i =  soda.min-1; i < soda.max; i++) {
                dp[i] = true;
            }
        }

//        for (Soda soda : sodas) {
//            dp[soda.min][soda.max]
//        }
//
//        for (int i = 0; i < tMin; i++) {
//            for (int j = 0; j < tMax; j++) {
//
//            }
//        }

        return false;
    }


    public static void main(String[] args) {
        List<Soda> list = new ArrayList<>();

        list.add(new Soda(100, 120));
        list.add(new Soda(200, 240));
        list.add(new Soda(400, 410));

        System.out.println("DFS:");
        Printer.printResult(canGetDFS(list, 100, 110));
        Printer.printResult(canGetDFS(list, 90, 120));
        Printer.printResult(canGetDFS(list, 300, 360));
        Printer.printResult(canGetDFS(list, 310, 360));

        System.out.println("DP:");
        Printer.printResult(canGetDP(list, 100, 110));
        Printer.printResult(canGetDP(list, 90, 120));
        Printer.printResult(canGetDP(list, 300, 360));
        Printer.printResult(canGetDP(list, 310, 360));
    }
}
