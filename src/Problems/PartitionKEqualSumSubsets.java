package Problems;

import Tool.Common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shuhanliu on 10/23/18.
 */
public class PartitionKEqualSumSubsets {

    public static void main (String[] args) {
//        int[] nums = {4, 3, 2, 3, 5, 2, 1};
//        int k = 4;

        int[] nums = {2,2,10,5,2,7,2,2,13};
        int k = 3;

        System.out.println(canPartitionKSubsets(nums, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0)
            return false;

        int subSum = sum / k;
        Set<Integer> visited = new HashSet<Integer>();

//        int i = 0;
////        helper(nums, 0, 0, subSum, new ArrayList<>(), visited);
//        while (i < nums.length) {
//            if (!visited.contains(i)) {
//                List<Integer> tmp = new ArrayList<Integer>();
//                tmp.add(i);
//                helper(nums, i+1, nums[i], subSum, tmp, visited);
//            }
//            i++;
//        }
//
//        return visited.size() == nums.length;
        return canPartition(nums, 0, 0, subSum, visited, k);
    }

    public static boolean canPartition(int[] nums, int index, int curSum, int subSum, Set<Integer> visited, int k) {
        if (k == 0)
            return true;

        if (curSum == subSum) {
            return canPartition(nums, 0, 0, subSum, visited, k-1);
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                if (canPartition(nums, i+1, curSum + nums[i], subSum, visited, k))
                    return true;
                visited.remove(i);
            }
        }

        return false;
    }

//    public static void helper(int[] nums, int index, int curSum, int subSum, List<Integer> tmp, Set<Integer> visited) {
////        Common.printList(tmp);
//
//        for (Integer i : tmp) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println(": " + curSum);
//
//        if (curSum == subSum) {
//            addMark(tmp, visited);
//            return;
//        }
//
//        if (curSum > subSum)
//            return;
//
//        for (int i = index; i < nums.length; i ++) {
//            if (!visited.contains(i)) {
//                tmp.add(i);
//                curSum += nums[i];
//                helper(nums, i+1, curSum, subSum, tmp, visited);
//                curSum -= nums[i];
//                tmp.remove(tmp.size()-1);
//
//                if (visited.contains(i))
//                    break;
//            }
//        }
//    }

//    public static void addMark(List<Integer> tmp, Set<Integer> visited) {
//        for (Integer i : tmp) {
//            visited.add(i);
//        }
//
//        System.out.print("Visited: ");
//        for (Integer i : visited) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
}
