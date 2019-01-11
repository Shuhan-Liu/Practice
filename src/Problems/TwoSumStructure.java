package Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shuhanliu on 10/21/18.
 */
public class TwoSumStructure {

    static Set<Integer> set;
    static List<Integer> list;

    public TwoSumStructure () {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    public static void add (int number) {
        for (Integer i : list) {
            if (!set.contains(i + number)) {
                set.add(i + number);
            }
        }
        list.add(number);
    }

    public static boolean find (int value) {
        return set.contains(value);
    }

    public static void main (String[] args) {
        TwoSumStructure twoSum = new TwoSumStructure();
        add(1);
        add(3);
        add(5);
        System.out.println(find(4));
        System.out.println(find(7));
    }
}
