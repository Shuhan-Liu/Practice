package Problems.Phone;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/29/19.
 */
public class AddTwoIntegers {

    public static void main(String[] args) {
        int[] arr2 = {-1, 2, 3};
        int[] arr1 = {2, 9};
        Printer.printArr(addTwoInteger(arr1, arr2));
    }

    public static int[] addTwoInteger(int[] arr1, int[] arr2) {

        List<Integer> rtn = new ArrayList<>();

        int flag = 1;
        int operatorFlag = 1;
        if (arr1[0] < 0 && arr2[0] < 0) {
            flag = 0;
            operatorFlag = 1;
        } else if (arr1[0] < 0 || arr2[0] < 0) {
            flag = 1;
            operatorFlag = 0;
            if (arr2.length > arr1.length) {
                int[] tmp = arr2;
                arr2 = arr1;
                arr1 = tmp;
            }
        }
        arr1[0] = Math.abs(arr1[0]);
        arr2[0] = Math.abs(arr2[0]);

        int len1 = arr1.length;
        int len2 = arr2.length;

        int m = len1 - 1;
        int n = len2 - 1;
        int addOn = 0;
        while (m >= 0 && n >= 0) {
            int sum = 0;
            if (operatorFlag == 0) {
                sum = arr1[m] - arr2[n] - addOn;
            }else {
                sum = arr1[m] + arr2[n] + addOn;
            }
            if (sum >= 10) {
                sum = sum % 10;
                addOn = 1;
            } else if (sum < 0) {
                sum = 10 + sum;
                addOn = 1;
            } else {
                addOn = 0;
            }

            rtn.add(Math.abs(sum));
            m--;
            n--;
        }

        while (m >= 0) {
            int sum;
            if (operatorFlag == 0) {
                sum = arr1[m] - addOn;
            }else {
                sum = arr1[m] + addOn;
            }
            if (sum >= 10) {
                sum = sum % 10;
                addOn = 1;
            } else if (sum < 0) {
                sum = 10 + sum;
                addOn = 1;
            } else {
                addOn = 0;
            }
            rtn.add(Math.abs(sum));
            m--;
        }

        while (n >= 0) {
            int sum;
            if (operatorFlag == 0) {
                sum = arr2[n] - addOn;
            }else {
                sum = arr2[n] + addOn;
            }
            if (sum >= 10) {
                sum = sum % 10;
                addOn = 1;
            } else if (sum < 0) {
                sum = 10 + sum;
                addOn = 1;
            } else {
                addOn = 0;
            }
            rtn.add(Math.abs(sum));
            n--;
        }

        if (addOn == 1) {
            rtn.add(1);
        }
        int[] rtnArr = new int[rtn.size()];
        for (int i = rtn.size()-1; i >= 0; i--) {
            rtnArr[rtn.size()-1-i] = rtn.get(i);
        }
        if (flag == 0) {
            rtnArr[0] = -rtnArr[0];
        }
        return rtnArr;
    }
}
