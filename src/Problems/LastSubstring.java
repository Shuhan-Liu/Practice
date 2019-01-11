package Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shuhanliu on 10/7/18.
 */
public class LastSubstring {
    public static void main(String[] args) {
        String s = "banana";
        String s1 = "zazy";
        System.out.println(lastSubstring(s));
        System.out.println(lastSubstring(s1));
    }

    public static String lastSubstring(String s) {
        char maxChar = 'a';
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > maxChar) {
                list = new ArrayList<String>();
                maxChar = s.charAt(i);
            }
            list.add(s.substring(i));
        }

        Collections.sort(list);

        return list.get(list.size()-1);
    }
}
