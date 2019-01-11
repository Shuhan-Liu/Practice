package Problems;

import Tool.Common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuhanliu on 12/12/18.
 */
public class LongestConsecutiveSequence {

    public static void main (String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            if (map.containsKey(i))
                continue;
            int minusOne = map.getOrDefault(i-1, 0);
            int plusOne = map.getOrDefault(i+1, 0);
            int cur = minusOne + 1 + plusOne;

            map.put(i, cur);
            map.put(i-minusOne, cur);
            map.put(i+plusOne, cur);

            max = Math.max(max, cur);
        }
        return max;
    }
}
