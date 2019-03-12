package Problems.Onsite;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/11/19.
 * LC890
 * 给一个word list和一个pattern，返回list中所有和pattern相match的单词
 此处的match为能在pattern和word之间找到一个双射函数，和LC 205 Isomorphic String中的双射函数一样

 思路：
 1. 用两个map，用putIfAbsent存互相的对应关系，然后再查一遍对应
 2. 单map把string转换成pattern array，用map.put(char, map.size())存不存在的char
 这道题目本质是LC205

 */
public class WordPatternMatch {

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        Printer.printList(findAndReplacePattern(words, pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> rtn = new ArrayList<>();
        if (words.length == 0)
            return rtn;

        for (String word : words) {
            if (isIsomorphic(word, pattern))
                rtn.add(word);
        }

        return rtn;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1) && map1.get(c1) != c2) {
                return false;
            }

            if (map2.containsKey(c2) && map2.get(c2) != c1) {
                return false;
            }

            map1.put(c1, c2);
            map2.put(c2, c1);
        }

        return true;
    }
}
