package Problems;

import Tool.Common;

import java.util.*;

/**
 * Created by shuhanliu on 11/28/18.
 */
public class EvaluateDivision {

    public static void main (String[] args) {
        String[][] equations = { {"a", "b"}, {"b", "c"} };
        double[] values = {2.0, 3.0};
        String[][] queries = {
                {"a", "c"},
                {"b", "a"},
                {"a", "e"},
                {"a", "a"},
                {"x", "x"}
        };

        double[] ret = calcEquation(equations, values, queries);
        Common.printArr(ret);
    }

    static class Tuple{
        double multi;
        String str;
        public Tuple(String str, double multi) {
            this.str = str;
            this.multi = multi;
        }

        public String toString() {
            return "[" + multi + ", " + str + "]";
        }
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int queryNum = queries.length;
        double[] ret = new double[queryNum];
        Map<String, List<Tuple>> map = new HashMap<>();

        // construct map
        for (int i = 0; i < values.length; i++) {
            String[] equation = equations[i];
            String first = equation[0];
            String second = equation[1];
            double value = values[i];

            if (map.containsKey(second)) {
                map.get(second).add(new Tuple(first, value));
            } else {
                List<Tuple> list = new ArrayList<>();
                list.add(new Tuple(first, value));
                map.put(second, list);
            }

            if (value != 0)
                value = 1/value;

            if (map.containsKey(first)) {
                map.get(first).add(new Tuple(second, value));
            } else {
                List<Tuple> list = new ArrayList<>();
                list.add(new Tuple(second, value));
                map.put(first, list);
            }
        }

        // print hashmap
        for (Map.Entry<String, List<Tuple>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            List<Tuple> list = entry.getValue();
            for (Tuple t : list) {
                System.out.print(t.toString() + " ");
            }
            System.out.println();
        }


        // query
        for (int i = 0; i < queryNum; i++) {
            String[] query = queries[i];
            String end = query[0];
            String start = query[1];

            if (map.containsKey(start) && map.containsKey(end)) {
                ret[i] = search(map, start, end, 1, new HashSet<String>());
            } else {
                ret[i] = -1;
            }

            System.out.println("Query: " + end + " / " + start + " = " + ret[i]);
        }

        return ret;
    }

    public static double search(Map<String, List<Tuple>> map, String cur, String end, double curVal, Set<String> visited) {

        if (cur.equals(end)) {
            return curVal;
        }

        List<Tuple> list = map.get(cur);
        for (Tuple t : list) {
            if (visited.contains(t.str))
                continue;
            visited.add(t.str);
            double ans = search(map, t.str, end, curVal*t.multi, visited);
            if (ans != -1)
                return ans;
        }

        return -1;
    }
}
