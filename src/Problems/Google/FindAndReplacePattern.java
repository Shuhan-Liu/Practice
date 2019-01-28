package Problems.Google;

import java.util.*;

/**
 * Created by shuhanliu on 1/19/19.
 */
public class FindAndReplacePattern {

    public static void main (String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> ret = findAndReplacePattern(words, pattern);
        for (String word : ret) {
            System.out.print(word + " ");
        }
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word, pattern))
                ret.add(word);
        }
        return ret;
    }

    public static boolean isMatch(String word, String pattern) {

        if (pattern.length() != word.length())
            return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (map1.containsKey(p)) {
                if (w != map1.get(p))
                    return false;
            }

            if (map2.containsKey(w)) {
                if (p != map2.get(w))
                    return false;
            }

            map1.put(p, w);
            map2.put(w, p);
        }

        return true;
    }
}
