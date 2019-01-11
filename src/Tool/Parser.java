package Tool;

/**
 * Created by shuhanliu on 1/6/19.
 */
public class Parser {
    public static int[][] parse2dArrayFromString(String s) {
//        [[1,2],[2,3],[3,4],[4,1],[1,5]]
        String tmp = s.substring(1, s.length()-1);
        String[] arr = tmp.split(",");
        int m = arr.length;
        int n = arr[0].substring(1, arr[0].length()-1).split(",").length;
        int[][] ret = new int[m][n];
        int i = 0;
        for (String values : arr) {
            String[] valueArr = values.substring(1, values.length()-1).split(",");
            for (int j = 0; j < valueArr.length; j++) {
                ret[i][j] = Integer.parseInt(valueArr[j]);
            }
            i++;
        }
        return ret;
    }
}
