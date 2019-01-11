package Problems;

/**
 * Created by shuhanliu on 12/15/18.
 */
public class Transform {

    public static void main (String[] args) {
        String start = "XXXXXLXXXX";
        String end = "LXXXXXXXXX";

        System.out.println(canTransform(start, end));
    }

    public static boolean canTransform(String start, String end) {
        boolean flag1 = helper(new StringBuilder(start), end, 0);
        System.out.println("FLAG ONE: " + flag1);
        boolean flag2 = helper(new StringBuilder(end), start, 0);
        System.out.println("FLAG TWO: " + flag2);
        return  flag1 || flag2;
    }

    public static boolean helper(StringBuilder sb, String end, int curIndex) {
        System.out.println(sb.toString());
        if (sb.toString().equals(end))
            return true;
        boolean flag = false;
        for (int i = curIndex; i < sb.length()-1; i++) {
            if (sb.charAt(i) == 'X' && sb.charAt(i+1) == 'L'){
                sb.setCharAt(i, 'L');
                sb.setCharAt(i+1, 'X');
                flag = helper(sb, end, i+1);
                sb.setCharAt(i, 'X');
                sb.setCharAt(i+1, 'L');
            } else if (sb.charAt(i) == 'R' && sb.charAt(i+1) == 'X') {
                sb.setCharAt(i, 'X');
                sb.setCharAt(i+1, 'R');
                flag = helper(sb, end, i+1);
                sb.setCharAt(i, 'R');
                sb.setCharAt(i+1, 'X');
            }

            if (flag)
                return flag;
        }
        return false;
    }
}
