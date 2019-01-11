package Problems;

import Tool.Printer;

import java.util.Arrays;

/**
 * Created by shuhanliu on 12/29/18.
 */
public class Heaters {

    public static void main (String[] args) {
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};

        Printer.printResult(findRadius(houses, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        Printer.printArr(Arrays.stream( houses ).boxed().toArray( Integer[]::new ));
        Printer.printArr(Arrays.stream( heaters ).boxed().toArray( Integer[]::new ));

        long max = Long.MIN_VALUE;
        int i = 0;
        for(int j = 0; j < heaters.length; j++) {
            long localMax = Long.MIN_VALUE;
            for (; i < houses.length; i++) {
                if (i > heaters[j])
                    break;
                long dist = heaters[j] - houses[i];
                if (j - 1 >= 0)
                    dist = Math.min(dist, houses[i] - heaters[j-1]);
                localMax = Math.max(localMax, dist);
            }
            max = Math.max(max, localMax);
        }
        for (int j = heaters.length-1; j >= 0; j--) {
            int pos = heaters[j];
            if (pos < houses[houses.length-1]) {
                max = Math.max(max, houses[houses.length-1] - pos);
                break;
            }
        }
        return (int)max;
    }
}
