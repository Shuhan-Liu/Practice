package Problems;

/**
 * Created by shuhanliu on 12/2/18.
 */
public class backSpaceCompare {

    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int len1 = S.length();
        int len2 = T.length();

        for (int i = 0; i < len1; i++) {
            addToSb(sb1, S.charAt(i));
        }

        for (int i = 0; i < len2; i++) {
            addToSb(sb2, T.charAt(i));
        }

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

//        return sb1.equals(sb2);
        return sb1.toString().equals(sb2.toString());
    }

    public static void addToSb(StringBuilder sb, Character c) {
        if (c != '#') {
            sb.append(c);
        } else if (c == '#' && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s1 = "a##c";
        String s2 = "#a#c";

        System.out.println(backspaceCompare(s1, s2));
    }
}
