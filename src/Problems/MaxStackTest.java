package Problems;


import java.util.Stack;

/**
 * Created by shuhanliu on 10/10/18.
 */
public class MaxStackTest {

    public static Stack<Integer> stack;
    public static int curMax;

    /**
     * initialize your data structure here.
     */
    public MaxStackTest() {
        this.stack = new Stack<Integer>();
        this.curMax = Integer.MIN_VALUE;
    }

    public static void push(int x) {
        if (x > curMax) {
            curMax = x;
        }
        stack.push(x);
        stack.push(curMax);
    }

    public static int pop() {
        stack.pop();
        int i = stack.pop();
        if (stack.isEmpty()) {
            curMax = Integer.MIN_VALUE;
        } else {
            curMax = stack.peek();
        }
        return i;
    }

    public static int top() {
        stack.pop();
        int peek = stack.peek();
        stack.push(curMax);
        return peek;
    }

    public static int peekMax() {
        return stack.peek();
    }

    public static int popMax() {
        Stack<Integer> tmp = new Stack<Integer>();
        boolean found = false;
        int rtn = curMax;

        while (!found) {
            int first = stack.pop();
            int second = stack.pop();
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            System.out.println("Curmax: " + curMax);
            if (curMax == second) {
                found = true;
            } else {
                tmp.push(second);
            }
        }

        if (stack.isEmpty())
            curMax = Integer.MIN_VALUE;
        else
            curMax = stack.peek();

        while (!tmp.isEmpty()) {
            int n = tmp.pop();
            if (n > curMax) {
                curMax = n;
            }
            stack.push(n);
            stack.push(curMax);
        }

        return rtn;
    }

    public static void drawStack() {
        System.out.println("Current Stack: ");
        Stack<Integer> tmpStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            System.out.println("|"+pop +"|");
            System.out.println("---");
            tmpStack.push(pop);
        }

        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
        System.out.println("FINISHED PRINTING");
    }

    public static void main (String[] args) {
//        MaxStackTest myStack = new MaxStackTest();
//        myStack.push(74);
//        System.out.println(myStack.popMax());
//        myStack.push(89);
//        myStack.push(67);
//        System.out.println(myStack.popMax());
//        System.out.println(myStack.pop());
//        drawStack();
//        myStack.push(61);
//        myStack.push(-77);
//
//        System.out.println(myStack.peekMax());
//        System.out.println(myStack.popMax());

        MaxStackTest myStack = new MaxStackTest();
        myStack.push(79);
        System.out.println(myStack.pop());
        myStack.push(14);
        myStack.push(67);
        myStack.push(19);
        myStack.push(-92);
        System.out.println(myStack.popMax());
        myStack.push(77);
        System.out.println(myStack.pop());
        drawStack();
        myStack.push(53);
        myStack.push(5);
        System.out.println(myStack.peekMax());
        System.out.println(myStack.popMax());

//        System.out.println(myStack.peekMax());
//        System.out.println(myStack.popMax());


    }
}
