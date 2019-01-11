package Problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shuhanliu on 12/2/18.
 */
public class MinCostToHireKEmployee {

    static class Tuple {
        int quality;
        int wage;

        public Tuple(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }

        public String toString() {
            return "quality: " + quality + " wage: " + wage + " ratio: " + (double)wage / quality;
        }
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // quality[i]   money[i]
        // ---------- = ----------
        // quality[j]   money[j]

        // money[i]     money[j]
        // ---------- = ----------  = ratio
        // quality[i]   quality[j]

        // money[i] >= wage[i]

        // money[i]                 wage[i]
        // ----------- = ratio >= ----------- = ratio2
        // quality[i]               quality[i]

        // so every time, the total paid money is the max current ratio times total quality
        // so we need to remove the highest quality

        PriorityQueue<Tuple> queue = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple t1, Tuple t2) {
                double r1 = (double)t1.wage / t1.quality;
                double r2 = (double)t2.wage / t2.quality;
                if (r1 > r2)
                    return 1;
                return -1;
            }
        });


        for (int i = 0; i < wage.length; i++) {
            Tuple t = new Tuple(quality[i], wage[i]);
//            if (queue.size() == K) {
//                queue.poll();
//            }
            queue.offer(t);
        }

        Tuple peek = queue.peek();
        double ratio = (double)peek.wage / peek.quality;
        System.out.println("Ratio: " + ratio);

        double minPayment = 0;
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            minPayment += t.quality * ratio;
            System.out.println(t.toString());
        }
        return minPayment;
    }

    public static void main (String[] args) {
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int K = 2;

        System.out.println(mincostToHireWorkers(quality, wage, K));
    }
}
