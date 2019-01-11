package Problems.BFSDFS;

import Tool.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuhanliu on 12/16/18.
 *
 * Time complexity is (2^n)
 *
 */
public class CombinationSumII {

    public static void main (String[] args) {
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;
        int[] candidates = {1, 1, 1, 2, 3};
        int target = 3;
        List<List<Integer>> ret = combinationSumII(candidates, target);
        Printer.print2DList(ret);
    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, 0, target, new ArrayList<>(), ret);
        return ret;
    }

    public static void helper(int[] candidates, int curPos, int curSum, int target, List<Integer> curList, List<List<Integer>> ret) {

        if (curSum > target)
            return;
        if (curSum == target) {
            ret.add(new ArrayList<>(curList));
            return;
        }

        for (int i = curPos; i < candidates.length; i++) {
            if (i > curPos && candidates[i] == candidates[i-1])
                continue;
            curList.add(candidates[i]);
            helper(candidates, i+1, curSum + candidates[i], target, curList, ret);
            curList.remove(curList.size()-1);
        }
    }

}
