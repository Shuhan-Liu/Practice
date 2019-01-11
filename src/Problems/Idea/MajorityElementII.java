package Problems.Idea;

import Tool.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhanliu on 11/27/18.
 */
public class MajorityElementII {

    public static void main (String[] args) {
        int[] arr = {1, 3, 2, 3, 2, 3, 2, 3};
        List<Integer> ret = majorityElement(arr);
        System.out.println("Majority Element: ");
        Common.printList(ret);
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        if (nums.length == 0)
            return ret;

        int countA = 0;
        int countB = 0;
        int tmpA = nums[0];
        int tmpB = nums[0];

        for (int num : nums) {
            if (num == tmpA)
                countA++;
            else if (num == tmpB)
                countB++;
            else if (countA == 0) {
                tmpA = num;
                countA = 1;
            } else if (countB == 0) {
                tmpB = num;
                countB = 1;
            } else {
                countA--;
                countB--;
            }
        }

        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == tmpA)
                countA++;
            else if (num == tmpB)
                countB++;
        }

        if (countA > nums.length/3)
            ret.add(tmpA);
        if (countB > nums.length/3)
            ret.add(tmpB);

        return ret;
    }
}
