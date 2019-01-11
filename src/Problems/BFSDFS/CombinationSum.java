package Problems.BFSDFS;

import Tool.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhanliu on 12/16/18.
 *
 * This algorithm has time complexity O((n+k)!)
 * where n is the size of candidates,
 * and k is the max repeated times for each candidates
 *
 */
public class CombinationSum {

    public static void main (String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> ret = combinationSum(candidates, target);
        Printer.print2DList(ret);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(candidates, 0, 0, target, new ArrayList<>(), ret);
        return ret;
    }

    public static void helper(int[] candidates, int curPos, int curSum, int target, List<Integer> curList, List<List<Integer>> ret) {
        if (curSum > target)
            return;
        if (curSum == target) {
            ret.add(new ArrayList<Integer>(curList));
            return;
        }

        for (int i = curPos; i < candidates.length; i++) {
            curList.add(candidates[i]);
            helper(candidates, i, curSum + candidates[i], target, curList, ret);
            curList.remove(curList.size()-1);
        }
    }
}
