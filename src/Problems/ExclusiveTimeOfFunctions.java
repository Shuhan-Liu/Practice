package Problems;

import Tool.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by shuhanliu on 10/28/18.
 */
public class ExclusiveTimeOfFunctions {

    public enum Status {
        START,
        END
    }


    static class Info{
        int id;
        // 0 means start, 1 means end
        Status status;
        int time;
    }

    public static void main (String[] args) {
//        int n = 2;
//        String[] logs = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};

        int n = 1;
        String[] logs = {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};

        System.out.println("-----------------------");
        int[] rtn = exclusiveTime(n, new ArrayList<>(Arrays.asList(logs)));
        Common.printArr(rtn);
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] rtn = new int[n];
        Stack<Integer> callStack = new Stack<Integer>();

        Info prev = getInfo(logs.get(0));
        callStack.push(prev.id);
        int lastTime = prev.time;

//        for (int i = 1; i < logs.size(); i++) {
//            String[] cur = getInfo(logs.get(i));
//            if (cur[0].equals(stack.peek())) {
//                if (cur[1].equals("end") &)
//            }
//        }

//        for (int i = 1; i < logs.size(); i++) {
//            Info cur = getInfo(logs.get(i));
////            Info prev = callStack.peek();
//            if(cur.id == prev.id) {            // have same id
//                int time = 0;
//                if (prev.status == Status.START && cur.status == Status.END) {
//                    time = cur.time - prev.time + 1;
//                } else if (prev.status == Status.START && cur.status == Status.START) {
//                    time = cur.time - prev.time;
//                } else if (prev.status == Status.END && cur) {
//
//                }
//
//                rtn[prev.id] += time;
//            }
//        }

        for (int i = 1; i < logs.size(); i++) {
            Info cur = getInfo(logs.get(i));
            System.out.println("LastTime: " + lastTime);
            System.out.println("CurrTime: " + cur.time);
            System.out.println("StackPeek: " + (callStack.isEmpty() ? "Empty" : callStack.peek()));
            if (!callStack.isEmpty()) {
                if (cur.id == callStack.peek()) {
                    if (cur.status == Status.END) {
                        rtn[cur.id] += cur.time - lastTime + 1;
                        lastTime = cur.time + 1;
                        callStack.pop();
                    } else {
                        rtn[cur.id] += cur.time - lastTime;
                        lastTime = cur.time;
                        callStack.push(cur.id);
                    }
                } else {
                    rtn[callStack.peek()] += cur.time - lastTime;
                    lastTime = cur.time;
                    callStack.push(cur.id);
                }
            } else{
                callStack.push(cur.id);
                lastTime = cur.time;
            }
            System.out.println("StackPeek: " + (callStack.isEmpty() ? "Empty" : callStack.peek()));
            Common.printArr(rtn);
            System.out.println("-----------------------");
        }


        return rtn;
    }

    public static Info getInfo(String s) {
        Info info = new Info();
        String[] arr = s.split(":");
        info.id = Integer.parseInt(arr[0]);
        info.time = Integer.parseInt(arr[2]);
        info.status = arr[1].equals("start") ? Status.START : Status.END;

        return info;
    }
}
