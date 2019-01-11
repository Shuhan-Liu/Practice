package Tool;

import Structure.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by shuhanliu on 10/6/18.
 */
public class Common {

    public static void printArr(int[] arr) {
        for(Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printArr(double[] arr) {
        for(Double i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printArr(String msg, int[] arr) {
        System.out.print(msg + " : ");
        for(Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printIntegerHashSet(Set<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printStringHashSet(Set<String> list) {
        for (String i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print2DIntegerList(List<List<Integer>> lists) {
        System.out.println("[");
        for (List<Integer> list : lists) {
            System.out.print("[ ");
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> tmp = new Stack<>();

        while (!stack.isEmpty()) {
            System.out.print("|" + stack.peek());
            tmp.push(stack.pop());
        }
        System.out.println("]");

        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public static void printTreeNodeStack(Stack<TreeNode> stack) {
        Stack<TreeNode> tmp = new Stack<>();

        while (!stack.isEmpty()) {
            System.out.print("|" + stack.peek().val);
            tmp.push(stack.pop());
        }
        System.out.println("]");

        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public static void printHashMap(Map<Integer, Integer> map) {

        System.out.println("------Map------");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
