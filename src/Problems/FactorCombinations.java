package Problems;

import Tool.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhanliu on 10/29/18.
 */
public class FactorCombinations {

    public static void main (String[] args) {
        int n = 12;
        Common.print2DIntegerList(getFactors(n));
    }

    public static List<List<Integer>> getFactors (int n) {
        List<List<Integer>> rtn = new ArrayList<>();
        if (n <= 2)
            return rtn;
        getFactorsHelper(n, 2, new ArrayList<>(), rtn);

//        if (rtn.size() > 0)
//            rtn.remove(rtn.size()-1);

        return rtn;
    }

    public static void getFactorsHelper (int n, int cur, List<Integer> curList, List<List<Integer>> rtn) {
        Common.printList(curList);
        if (n == 1) {
            rtn.add(new ArrayList<>(curList));
            return;
        }

        for (int i = cur; i*i <= n; i++) {
            if (n % i == 0) {
                curList.add(i);
                curList.add(n/i);
                rtn.add(new ArrayList<>(curList));
                curList.remove(curList.size()-1);
                getFactorsHelper(n/i, i, curList, rtn);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
