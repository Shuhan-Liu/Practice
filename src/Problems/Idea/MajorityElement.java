package Problems.Idea;

/**
 * Created by shuhanliu on 11/27/18.
 */
public class MajorityElement {

    public static void main (String[] args) {
        int[] arr = {1, 3, 2, 3, 4, 3};
        int ret = majorityElement(arr);
        System.out.println("Majority Element: " + ret);
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 0)
            return 0;
        int counter = 1;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp != nums[i]) {
                counter--;
            } else {
                counter++;
            }

            if (counter == 0) {
                tmp = nums[i];
                counter = 1;
            }
        }
        return tmp;
    }
}
