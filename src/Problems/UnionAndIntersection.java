package Problems;

import Tool.Common;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuhanliu on 11/1/18.
 */
public class UnionAndIntersection {

    public static void main (String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};

        Common.printArr(union(arr1, arr2));
        Common.printArr(union2(arr1, arr2));
        Common.printArr(intersection(arr1, arr2));
    }

    public static int[] union (int[] arr1, int[] arr2) {
//        int[] union = new int[0];

        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1)
            set.add(i);
        for (int i : arr2)
            set.add(i);

        Object[] setArr = set.toArray();

        int[] union = new int[set.size()];

        for (int i = 0; i < set.size(); i++) {
            union[i] = (int)setArr[i];
        }
        return union;
    }

    public static int[] union2 (int[] arr1, int[] arr2) {
//        int[] union = new int[0];

        List<Integer> list = new LinkedList<Integer>();
        int i = 0;
        int j = 0;

        int curIndex = -1;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (curIndex == -1) {
                    list.add(arr1[i]);
                    curIndex++;
                    continue;
                }

                if (list.get(curIndex) != arr1[i]) {
                    list.add(arr1[i]);
                    curIndex++;
                }
                i++;
            } else {

                if (curIndex == -1) {
                    list.add(arr2[j]);
                    curIndex++;
                    continue;
                }

                if (list.get(curIndex) != arr2[j]) {
                    list.add(arr2[j]);
                    curIndex++;
                }
                j++;
            }
        }

        if (i < arr1.length) {
            if (list.get(curIndex) != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }

        if (j < arr2.length) {
            if (list.get(curIndex) != arr2[j]) {
                list.add(arr2[j]);
            }
            j++;
        }

        int[] union = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            union[k] = list.get(k);
        }

        return union;
    }

    public static int[] intersection (int[] arr1, int[] arr2) {

        List<Integer> list = new LinkedList<>();
        int i = 0;
        int j = 0;
        int curIndex = -1;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                if (curIndex == -1) {
                    list.add(arr1[i]);
                    curIndex++;
                } else {
                    if (list.get(curIndex) != arr1[i]) {
                        list.add(arr1[i]);
                        curIndex++;
                    }
                }
                i++;
                j++;
            }
        }

        int[] intersection = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            intersection[k] = list.get(k);
        }

        return intersection;
    }
}
