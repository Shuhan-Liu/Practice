package Problems;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 12/25/18.
 */
public class WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        Printer.printList(wordBreak(s, Arrays.asList(wordDict)));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        helper(s, wordDict, map, ret, cur);
        return ret;
    }

    public static void helper(String s, List<String> wordDict, Map<String, List<String>> map, List<String> ret, List<String> cur) {
        if (s.length() == 0) {
            ret.add(createString(cur));
            return;
        }
//        if (map.containsKey(s)) {
//            System.out.println("s  : " + s);
//            System.out.println("cur: " + createString(cur));
//            map.put(createString(cur) + " " + s, new ArrayList<>());
//            for (String sub : map.get(s)) {
//                cur.add(sub);
//                ret.add(createString(cur));
//                cur.remove(cur.size()-1);
//                map.get(createString(cur) + " " + s).add(createString(cur) + sub);
////                Printer.printList();
//            }
//            return;
//        }
        for (String word : wordDict) {
            if (word.length() <= s.length() && s.substring(0, word.length()).equals(word)) {
                cur.add(word);
                helper(s.substring(word.length()), wordDict, map, ret, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static String createString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size()-1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
