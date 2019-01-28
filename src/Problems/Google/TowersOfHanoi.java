package Problems.Google;

import java.util.*;

/**
 * Created by shuhanliu on 1/27/19.
 * Play the classic towers of Hanoi game
 * using stack recursively
 */
public class TowersOfHanoi {

    private static Stack<Integer> beg = new Stack<>();
    private static Stack<Integer> mid = new Stack<>();
    private static Stack<Integer> end = new Stack<>();

    public static void main (String[] args) {
        int n = 3;
        playTowerOfHanoi(n);
    }

    public static void playTowerOfHanoi (int n) {

        for (int i = n; i > 0; i--) {
            beg.push(i);
        }

        display();
        move(n, beg, mid, end);
    }

    public static void move(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (n > 0) {
            move(n-1, a, c, b);
            int i = a.pop();
            c.push(i);
            display();
            move(n-1, b, a, c);
        }
    }

    public static void display() {
        printStack("BEG", beg);
        printStack("MID", mid);
        printStack("END", end);
        System.out.println("----------");
    }

    public static void printStack(String str, Stack<Integer> s) {
        System.out.print(str + ": ");
        Stack<Integer> tmp = new Stack<>();
        while(!s.isEmpty()) {
            tmp.push(s.pop());
        }
        while (!tmp.isEmpty()) {
            int i = tmp.pop();
            System.out.print(i + "-");
            s.push(i);
        }
        System.out.println();
    }
}
