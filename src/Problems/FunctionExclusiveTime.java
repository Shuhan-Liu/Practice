package Problems;

import Tool.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuhanliu on 10/25/18.
 */
public class FunctionExclusiveTime {

    public static void main(String[] args) {
//        int n = 2;
//        String[] arr = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};

//        int n = 1;
//        String[] arr = {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};

        int n = 2 ;
        String[] arr = {"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};


        List<String>logs = new ArrayList<>(Arrays.asList(arr));

        int[] result = exclusiveTime(n, logs);
        Common.printArr(result);
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] rtn = new int[n];

        int curFun = Integer.parseInt(logs.get(0).split(":")[0]);
        String curState = logs.get(0).split(":")[1];
        int curTime = Integer.parseInt(logs.get(0).split(":")[2]);

        for (int i = 1; i < logs.size(); i++) {
            String[] infoArr = logs.get(i).split(":");
            int nextFun = Integer.parseInt(infoArr[0]);
            String nextState = infoArr[1];
            int nextTime = Integer.parseInt(infoArr[2]);

            int timeGap = nextTime - curTime;

            if (nextFun == curFun && curState.equals("start") && nextState.equals("end")) {
                rtn[curFun] += timeGap + 1;
            } else if (curState.equals("end") && nextState.equals("end")) {
                rtn[nextFun] += timeGap;
            } else if (curState.equals("start") && nextState.equals("start")) {
                rtn[curFun] += timeGap;
            } else if (nextFun != curFun && curState.equals("end") && nextState.equals("start")) {
                rtn[curFun] += timeGap - 1;
            }

            System.out.println("curFun: " + curFun + " curState: " + curState + " curTime: " + curTime);
            System.out.println("nextFun: " + nextFun + " nextState: " + nextState + " nextTime: " + nextTime);
            System.out.println();

            curFun = nextFun;
            curState = nextState;
            curTime = nextTime;
        }

        return rtn;
    }

}
