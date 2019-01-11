package Problems.Test;

import Tool.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuhanliu on 1/8/19.
 */
public class Test {

    public static void main(String[] args){
        String[] arr1 = {"a a a a a a a","aa a a a a a","a aa a a a a","a a aa a a a","aa aa a a a","aaaa a a a","a a a aa a a","aa a aa a a","a aa aa a a","a aaaa a a","a a a a aa a","aa a a aa a","a aa a aa a","a a aa aa a","aa aa aa a","aaaa aa a","a a aaaa a","aa aaaa a","a a a a a aa","aa a a a aa","a aa a a aa","a a aa a aa","aa aa a aa","aaaa a aa","a a a aa aa","aa a aa aa","a aa aa aa","a aaaa aa","a a a aaaa","aa a aaaa","a aa aaaa"};
        String[] arr2 = {"a a a a a a a","a a a a a aa","a a a a aa a","a a a aa a a","a aa a a aa","a a a aaaa","a a aa a a a","aa a a a aa","a a aa aa a","a a aaaa a","a aa a a a a","aa a a a aa","a a aa aa a","aa a aa a a","aa aa a aa","a aa aaaa","a aaaa a a","aaaa a aa","aa a a a a a","aa a a a aa","a a aa aa a","aa a aa a a","aa aa a aa","a aa aaaa","aa aa a a a","aa aa a aa","aa aa aa a","aa aaaa a","aaaa a a a","aaaa a aa","aaaa aa a"};
        System.out.println(isSame(arr1, arr2));
    }

    public static boolean isSame(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);

//        Printer.printArr(arr1);
//        Printer.printArr(arr2);

//        for (int i = 0; i < arr1.length; i++) {
//            if (!arr1[i].equals(arr2[i]))
//                System.out.println(arr1[i] + " : " + arr2[i]);
////                return false;
//        }
        Set<String> set = new HashSet<>();
        for (String s : arr1)
            set.add(s);
        for (String s : arr2) {
            if (!set.contains(s)) {
                System.out.println(s);
                return false;
            }

        }
        return true;
    }
}
