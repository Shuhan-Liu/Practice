package Problems;

import Tool.Printer;

import java.util.Stack;

/**
 * Created by shuhanliu on 12/25/18.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
//        String s = "(()";
        String s = "()(()";
        Printer.printResult(longestValidParentheses(s));
    }

    static class Pair {
        public int index;
        public int val;
        public Pair (int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public static int longestValidParentheses(String s) {

        char[] arr = s.toCharArray();
        Stack<Pair> stack = new Stack<>();
        int maxLen = 0;
        int curLen = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(new Pair(i, 0));
            } else {
                if (stack.isEmpty() || stack.peek().val == 1) {
                    stack.push(new Pair(i, 1));
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        curLen = i + 1;
                    } else {
                        curLen = i - stack.peek().index;
                    }
                    maxLen = Math.max(maxLen, curLen);
                }
            }
        }

        return maxLen;
    }


    // bad try
    public static int longestValidParenthesesBad(String s) {
        char[] arr = s.toCharArray();
        if (arr.length < 2)
            return 0;

        int left = 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                sum -= 1;
            } else {
                sum += 1;
            }

            while (sum < 0 && left < arr.length) {
                if (arr[left] == ')') {
                    sum += 1;
                } else {
                    sum -= 1;
                }
                left ++;
            }
            if (sum == 0) {
                max = Math.max(max, i - left + 1);
            }
        }

        System.out.println("max: " + max + " left: " + left + " sum: " + sum);

        while (sum != 0 && left < arr.length) {
            if (arr[left] == ')') {
                sum += 1;
            } else {
                sum -= 1;
            }
            left ++;
        }

        if (sum == 0)
            max = Math.max(max, arr.length - 1 - left + 1);

        return max;
    }
}
