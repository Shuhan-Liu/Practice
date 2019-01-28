package Problems.Google;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/20/19.
 */
public class KingPlace {

    static Map<String, List<String>> map = new HashMap<>();
    static Set<String> dead = new HashSet<>();
    static String root = "King";

    // 父亲名字和孩子名字，生个娃
    static void birth(String parent, String name) {
        if (!map.containsKey(parent))
            map.put(parent, new ArrayList<>());
        map.get(parent).add(name);
    }

    // 此人要死
    static void death(String name) {
        dead.add(name);
    }

    // 返回当前的继承顺序，string array/list
    static List<String> getOrder() {

        List<String> ret = new ArrayList<>();
        dfs(root, ret);

        return ret;
    }

    static void dfs(String cur, List<String> ret) {
        if (!dead.contains(cur))
            ret.add(cur);
        if (!map.containsKey(cur))
            return;
        List<String> children = map.get(cur);
        for (String child : children) {
            dfs(child, ret);
        }
    }

    public static void main (String[] args) {
        map.put(root, new ArrayList<>());
        birth("King", "son1");
        birth("King", "son2");
        birth("son1", "sun1");
        birth("son2", "sun2");
        Printer.printList(getOrder());
        death("son1");
        Printer.printList(getOrder());
    }
}
