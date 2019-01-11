package Problems.Idea;

import Tool.Common;

import java.util.HashMap;

/**
 * Created by shuhanliu on 11/27/18.
 */
public class FruitTree {

    public static void main(String[] args) {
//        int[] arr = {4, 1, 1, 1, 3, 1, 7, 5};
        int[] arr = {0, 1, 2, 2};
        System.out.println(totalFruit(arr));
        System.out.println(totalFruit2(arr));
    }

    public static int totalFruit2(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int first = 0;
        int second = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[first]) {
                count++;
                first = i;
            } else if (second == -1 || nums[i] == nums[second]) {
                count++;
                second = i;
            } else {
                maxCount = Math.max(maxCount, count);
                count = Math.abs(second - first) + 1;
                first = i-1;
                second = i;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static int totalFruit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int start = 0;
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            System.out.println();
            System.out.println(nums[i]);
            Common.printHashMap(map);

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                count++;
            } else {
                if (map.size() == 2) {
                    for (int j = start; j < i; j++) {
                        map.put(nums[j], map.get(nums[j]) - 1);
                        count--;
                        if (map.get(nums[j]) == 0) {
                            map.remove(nums[j]);
                            start = j + 1;
                            map.put(nums[i], 1);
                            count++;
                            break;
                        }
                    }
                } else {
                    map.put(nums[i], 1);
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
