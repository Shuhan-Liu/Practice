package Structure;

import java.util.Stack;

/**
 * Created by shuhanliu on 10/10/18.
 */
public class MaxStack {
    public Stack<Integer> stack;
    public int curMax;

    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new Stack<Integer>();
        this.curMax = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (x > curMax) {
            curMax = x;
        }
        stack.push(x);
        stack.push(curMax);
    }

    public int pop() {
        stack.pop();
        return stack.pop();
    }

    public int top() {
        stack.pop();
        int peek = stack.peek();
        stack.push(curMax);
        return peek;
    }

    public int peekMax() {
        return stack.peek();
    }

    public int popMax() {
        Stack<Integer> tmp = new Stack<Integer>();
        boolean found = false;
        int rtn = curMax;

        while (!found) {
            int first = stack.pop();
            int second = stack.pop();
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
}
