package Tool;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shuhanliu on 12/16/18.
 */
public class Printer {

    public static <T> void printResult(T t) {
        System.out.println("Result: " + t);
    }

    public static <T> void printArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void printArr(int[] arr) {
        printArr(Arrays.stream(arr).boxed().toArray( Integer[]::new ));
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
}
