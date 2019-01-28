package Problems.Phone;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/22/19.
 *
 * ["Yellow", "Green", "Red"], [1,5,4] 三个颜色，
 * 出现的概率是10%， 50%， 40%，给一个random number，
 * 看return哪个颜色。
 *
 * Similar to leetcode 528
 *
 */
public class ColorPicker {

    static class Solution{
        int[] myArr;
        int curSum;
        Random rand;
        public Solution(int[] w) {
            myArr = new int[w.length];
            curSum = 0;
            rand = new Random();
            for (int i = 0; i < w.length; i++) {
                curSum += w[i];
                myArr[i] = curSum;
            }
        }

        public int pickIndex() {

            double val = rand.nextDouble()*curSum;

            int left = 0;
            int right = myArr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (myArr[mid] == val) {
                    return mid;
                } else if (myArr[mid] < val) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }
    }

    public static void main(String[] args) {
        String[] colors = {"Red", "Yellow", "Blue"};
        int[] weight = {1, 6, 3};

        Solution solution = new Solution(weight);
        Map<String, Float> map = new HashMap<>();
        int totalIterations = 100000;
        int i = 0;
        while (i < totalIterations) {
            int index = solution.pickIndex();
//            System.out.print(colors[index] + " ");
            map.put(colors[index], ((map.getOrDefault(colors[index], 0.0f) * totalIterations) + 1)/totalIterations);
            i++;
//            if (i % 10 == 0)
//                System.out.println();
        }
        Printer.printMap(map);
    }
}
