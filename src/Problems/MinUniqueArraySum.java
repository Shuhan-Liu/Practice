package Problems;

/**
 * Created by shuhanliu on 10/7/18.
 *
 * Given a sorted integer array,
 * return sum of array so that each element is unique
 * by adding some numbers to duplicate elements
 * so that sum of unique elements is minimum.
 * I.e., if all elements in the array are unique, return the sum.
 * If some elements are duplicates, then increment them to make sure
 * all elements are unique so that the sum of these unique elements is minimum.
 *
 */
public class MinUniqueArraySum {
    public static void main (String[] args) {
        int[] arr = {1, 2, 5, 6, 6, 7};
        System.out.println(minUniqueArraySum(arr));
    }

    public static int minUniqueArraySum(int[] arr) {
        int sum = arr[0];
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            while (prev >= cur) {
                cur++;
            }
            sum += cur;
            prev = cur;
        }
        return sum;
    }

}
