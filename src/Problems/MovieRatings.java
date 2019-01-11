package Problems;

/**
 * Created by shuhanliu on 10/7/18.
 */
public class MovieRatings {
    public static void main (String[] args) {
        int[] arr = {5, -1, -5, -2, 1, 9, -5};
        int[] arr2 = {9, -1, -3, 4, 5};
        System.out.println(maxRatingSumWithoutSkippingTwoElements(arr));
    }

    public static int maxRatingSumWithoutSkippingTwoElements(int[] arr) {

        int[] maxSum = new int[arr.length]; //max sum if we add ith element
        maxSum[0] = arr[0];
        maxSum[1] = arr[0] + arr[1];
        System.out.print(maxSum[0] + " " + maxSum[1] + " ");
        for (int i = 2; i < arr.length; i++) {

            maxSum[i] = Math.max(maxSum[i-2] + arr[i], maxSum[i-1] + arr[i]);

            System.out.print(maxSum[i] + " ");
        }
        System.out.println();
        return Math.max(maxSum[arr.length-1], maxSum[arr.length-2]);
    }
}
