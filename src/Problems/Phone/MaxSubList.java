package Problems.Phone;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/23/19.
 * 题目是随机给一个长度为1-10000的list nums，并随即给定一个int k。
 * 要求是计算所有长度为k的sub list并输出最大的sublist
 */
public class MaxSubList {

    public static void main(String[] args) {

        int len = 10;
        int k = 3;
        int maxVal = 20;
        Random random = new Random();

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(maxVal);
        }

        Printer.printArr(arr);

        List<Integer> list = findMaxSubList(arr, k);
        Printer.printList(list);
    }

    public static List<Integer> findMaxSubList(int[] arr, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int sum = 0;
        while (i < k && i < arr.length) {
            queue.offer(arr[i]);
            sum += arr[i];
            i++;
        }
        if (queue.size() < k)
            return new ArrayList<>(queue);
        int j = k;
        int max = sum;
        List<Integer> list = new ArrayList<>(queue);
        while (j < arr.length) {
            int first = queue.poll();
            int num = arr[j];
            queue.offer(num);

            sum -= first;
            sum += num;

            if (sum > max) {
                max = sum;
                list = new ArrayList<>(queue);
            }
            j++;
        }

        return list;
    }
}
