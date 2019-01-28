package Problems.Phone;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 1/22/19.
 *  一个secret sequence,  另一个人猜这个sequence，
 *  如果两个sequence里的元素位置和value都相同，第二个人会得到一个black reward，
 *  如果位置不同但是value相同，第二个人得到一个white reward。
 *  问第二个人能得多少个black 和 write rewards。
 *
 *  leetcode Bulls and cows
 */
public class SecretSequence {
    public static void main(String[] args) {

        String answer = "1100";
        String guess  = "1001";

        Printer.printResult(rewards(guess, answer));
    }

    public static String rewards(String guess, String answer) {

        StringBuilder sb = new StringBuilder();
        int same = 0;
        Map<Character, Integer> gMap = new HashMap<>();
        Map<Character, Integer> aMap = new HashMap<>();

        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            char a = answer.charAt(i);
            if (g == a) {
                same += 1;
            } else {
                gMap.put(g, gMap.getOrDefault(g, 0) + 1);
                aMap.put(a, aMap.getOrDefault(a, 0) + 1);
            }
        }

        int similar = 0;
        for (char c : gMap.keySet()) {
            if (aMap.containsKey(c)) {
                similar += Math.min(aMap.get(c), gMap.get(c));
            }
        }

        sb.append(same);
        sb.append('A');
        sb.append(similar);
        sb.append('B');

        return sb.toString();
    }
}
