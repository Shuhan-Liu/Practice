package Tool;

import Structure.TreeNode;

import java.util.*;

/**
 * Created by shuhanliu on 12/16/18.
 */
public class Printer {

    public static <T> void printResult(T t) {
        System.out.println("Result: " + t);
    }

    public static <T> void printArr(T[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static <T> void printArrTab(T[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length-1) {
                System.out.print(",\t");
            }
        }
        System.out.println("]");
    }

    public static void printArr(int[] arr) {
        printArr(Arrays.stream(arr).boxed().toArray( Integer[]::new ));
    }

    public static void printArrTab(int[] arr) {
        printArrTab(Arrays.stream(arr).boxed().toArray( Integer[]::new ));
    }

    public static <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    public static <T> void print2DList(List<List<T>> list) {
        for (List<T> tmp : list) {
            for (int i = 0; i < tmp.size(); i++) {
                System.out.print(tmp.get(i));
                if (i < tmp.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static <T> void print2DArray(T[][] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            T[] a = arr[i];
            System.out.print("[");
            for (T n : a) {
                System.out.print(n + " ");
            }
            if (i != arr.length-1)
                System.out.println("]");
            else
                System.out.println("]]");
        }
    }

    public static void print2DArray(boolean[][] arr) {
        print2DArray(Arrays.stream(arr).toArray(Integer[][]::new));
//        Arrays.stream(arr).map(row -> .of(row).boxed()).toArray(Integer[][]::new);
    }

    public static void print2DArray(int[][] arr) {
//        System.out.print("[");
//
//        for (int i = 0; i < arr.length; i++) {
//            int[] a = arr[i];
//            System.out.print("[");
//            for (int n : a) {
//                System.out.print(n + " ");
//            }
//            if (i != arr.length-1)
//                System.out.println("]");
//            else
//                System.out.println("]]");
//
//        }

        print2DArray(Arrays.stream(arr).toArray(Integer[][]::new));

//        print2DArray(Arrays.stream(arr).boxed().toArray( Integer[]::new ));
    }

    public static <T, E> void printMap(Map<T, E> map) {
        System.out.println("Map:");
        for (T key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    public static void printTree(TreeNode root) {
        int height = getHeight(root);
    }

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        return 1 + Math.max(leftH, rightH);
    }
}
