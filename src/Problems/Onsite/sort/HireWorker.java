package Problems.Onsite.sort;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/17/19.
 *
 * LC  857 Minimum Cost to Hire K Workers
 *
 * There are N workers.
 * The i-th worker has a quality[i] and a minimum wage expectation wage[i].
 *
 * Now we want to hire exactly K workers to form a paid group.
 * When hiring a group of K workers, we must pay them according to the following rules:
 *
 * Every worker in the paid group should be paid in the ratio of their quality
 * compared to other workers in the paid group.
 *
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * Return the least amount of money needed to form a paid group satisfying the above conditions.
 *
 * Input: quality = [10,20,5], wage = [70,50,30], K = 2
 * Output: 105.00000
 * Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
 */

/**
 *
 * 分析：
 * 1.这道题有点意思，要雇佣K个人，使得所花钱最少，雇佣需满足两个条件，
 * 一是最后给的钱必须成比例，二是不能低于最小值
 * 2.我们不妨设最后雇佣时给第i个人的钱为p[i]，则对于被选上的K个人来说，
 * 都有相同的比例 p[i] / quality[i]（根据条件1）
 *
 * 3.也就是说一旦我们选定了比例 r，那么最后选的K个人一定都满足
 * r * quality[i] > wage[i]（因为已经被选上了自然满足条件2）
 *
 * 4.上式逆推为 r > (wage/quality),故我们将所有人按照 wage/quality 的大小排序，
 * 依次作为r 来判断最后的总价格。
 *
 * 5.注意N,K都达到了10000，O(n^2)的方法显然不行（绝大部分情况下）
 *
 * 思路：
 *
 * 按照wage/quality排序，若选定第i个人的比例r作为标准，
 * 那么还需从0到i-1中的人选k-1个人
 *
 * 对于0到i-1个人，他们每个人的价格就是quality*r，r是固定的，
 * 所以quality越小越好，所以我们用最大堆将quality大的丢弃
 *
 * */
public class HireWorker {

    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {

        double[][] qualityAndRatio = new double[quality.length][2];

        for (int i = 0; i < quality.length; i++) {
            qualityAndRatio[i][0] = quality[i];
            qualityAndRatio[i][1] = (double)wage[i] / quality[i];
        }

        Arrays.sort(qualityAndRatio, (p1, p2) -> Double.compare(p1[1], p2[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        double minCost = Double.MAX_VALUE;
        double qualitySum = 0;
        for (int i = 0; i < qualityAndRatio.length; i++) {
            double curQ = qualityAndRatio[i][0];
            double curR = qualityAndRatio[i][1];

            pq.offer((int)curQ);
            qualitySum += curQ;

            if (pq.size() > K) {
                int polledQ = pq.poll();
                qualitySum -= polledQ;
            }

            if (pq.size() == K) {
                double money = qualitySum * curR;
                minCost = Math.min(money, minCost);

            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int K = 2;

        Printer.printResult(mincostToHireWorkers(quality, wage, K));
        Printer.printResult(minWageUseClass(quality, wage, K));
    }

    static class Worker{
        int quality;
        double wqRatio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wqRatio = (double) wage / quality;
        }

        @Override
        public String toString() {
            return "quality: " + quality + " wqRatio: " + wqRatio;
        }
    }

    public static double minWageUseClass(int[] quality, int[] wage, int K) {

        if (quality.length == 0 || quality.length != wage.length || K == 0)
            return 0;
        List<Worker> workerList = new ArrayList<>();

        for (int i = 0; i < quality.length; i++) {
            workerList.add(new Worker(quality[i], wage[i]));
        }

        workerList.sort((w1, w2) -> w1.wqRatio > w2.wqRatio ? 1 : -1);

        PriorityQueue<Worker> pq = new PriorityQueue<>((w1, w2) -> w2.quality - w1.quality);

        int qualitySum = 0;
        double minWage = Double.MAX_VALUE;

        for (Worker w : workerList) {
            pq.offer(w);

            if (pq.size() < K) {
                qualitySum += w.quality;
            } else{
                qualitySum += w.quality;
                if (pq.size() > K) {
                    qualitySum -= pq.poll().quality;
                }
                minWage = Math.min(minWage, w.wqRatio * qualitySum);
            }
        }

        return minWage;
    }

}
