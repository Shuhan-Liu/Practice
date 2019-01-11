package Problems.BFSDFS;

import Tool.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhanliu on 12/16/18.
 */
public class CombinationSumIII {

    public static void main (String[] args) {
        int k = 3;
        int n = 9;
        List<List<Integer>> ret = combinationSum3(k, n);
        Printer.print2DList(ret);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ret = new ArrayList<>();
        helper(candidates, k, n, 0, 0, new ArrayList<>(), ret);
        return ret;
    }

    public static void helper(int[] candidates, int k, int n, int curSum, int curPos, List<Integer> curList, List<List<Integer>> ret) {
        if (curList.size() == k) {
            if (curSum == n) {
                ret.add(new ArrayList<>(curList));
            }
            return;
        }

        for (int i = curPos; i < candidates.length; i++) {
            curList.add(candidates[i]);
            helper(candidates, k, n, curSum + candidates[i], i+1, curList, ret);
            curList.remove(curList.size()-1);
        }
    }
}
