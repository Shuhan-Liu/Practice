package Problems.Phone;

import Tool.Printer;

/**
 * Created by shuhanliu on 1/26/19.
 */
public class CompareVersions {

    public static void main (String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";

        Printer.printResult(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        Printer.printArr(arr1);
        Printer.printArr(arr2);

        int m = arr1.length;
        int n = arr2.length;
        int len = Math.min(m, n);

        for (int i = 0; i < len; i++) {
            int num1 = Integer.parseInt(arr1[i]);
            int num2 = Integer.parseInt(arr2[i]);

            System.out.println("num1 : num2 = " + num1 + " : " + num2);

            if (num1 > num2)
                return 1;
            if (num2 > num1)
                return -1;
        }

        if (m > len) {
            int sum = 0;
            int i = len;
            while (i < m) {
                sum += Integer.parseInt(arr1[i]);
                i++;
            }

            return sum > 0 ? 1 : 0;
        }

        if (n > len) {
            int sum = 0;
            int i = len;
            while (i < n) {
                sum += Integer.parseInt(arr2[i]);
                i++;
            }

            return sum > 0 ? -1 : 0;
        }

        return 0;
    }
}
