package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuhanliu on 10/7/18.
 *
 * Given array and target, return number of distinct pairs that sum to target
 */
public class DistinctPairs {
    public static void main (String[] args) {
        int[] arr = {1,2,3,6,7,8,9,1};
        int target = 10;

        int[] arr2 = {6,6,3,9,3,5,1};
        int target2 = 12;

        System.out.println(distinctPairs(arr, target));
        System.out.println(distinctPairs(arr2, target2));
    }

    public static int distinctPairs (int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        Set<Integer> set = new HashSet<Integer>();
        int count = 0;

        for (int i : arr) {
            if (map.containsKey(target - i)) {
                if (!map.containsKey(i)) {
                    count++;
                    map.put(i, 1);
                } else if (map.get(i) == 1 && target - i == i) {
                    count++;
                    map.put(i, 2);
                }
            } else {
                if (!map.containsKey(i))
                    map.put(i, 1);
                else
                    map.put(i, map.get(i) + 1);
            }
        }
        return count;
    }
}
