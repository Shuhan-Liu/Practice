package Problems;

/**
 * Created by shuhanliu on 10/7/18.
 *
 * left一位就abcd变为bcda
 *
 */
public class ShiftWord {
    public static void main (String[] args) {
        String s = "Oh! Leo's so smart!";
        System.out.println(s);
        System.out.println(shiftWord(s, 3));
    }

    public static String shiftWord (String s, int index) {
        if (s == null)
            return s;
        int len = s.length();
        if (len < 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < len; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < index; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
