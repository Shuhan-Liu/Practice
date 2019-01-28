package Problems.Phone;

import java.util.*;

/**
 * Created by shuhanliu on 1/22/19.
 * List 1 :  ["ab", 3], ["cd", 2],["fg", 4]
 * List 2: ["ab", 2], ["fg", 3]
 * 先合在一起，再排序。
 */
public class MergeAndSort {

    static class Tuple{
        String str;
        int val;

        Tuple(String str, int val) {
            this.str = str;
            this.val = val;
        }

        public String toString() {
            return this.str + "-" + this.val;
        }
    }

    public static void main(String[] args) {
        List<Tuple> list1 = new ArrayList<>();
        List<Tuple> list2 = new ArrayList<>();

        list1.add(new Tuple("ab", 3));
        list1.add(new Tuple("cd", 2));
        list1.add(new Tuple("fg", 4));

        list2.add(new Tuple("ab", 2));
        list2.add(new Tuple("fg", 3));

        List<Tuple> list = mergeAndSort(list1, list2);
        for (Tuple t : list) {
            System.out.print(t.toString() + " ");
        }
        System.out.println();
    }

    public static List<Tuple> mergeAndSort(List<Tuple> list1, List<Tuple> list2) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Tuple> queue = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if (o1.val == o2.val)
                    return o1.str.compareTo(o2.str);
                else
                    return o1.val - o2.val;
            }
        });

        for (Tuple t1 : list1) {
            map.put(t1.str, map.getOrDefault(t1.str, 0) + 1);
        }

        for (Tuple t2 : list2) {
            map.put(t2.str, map.getOrDefault(t2.str, 0) + 1);
        }

        for (String key : map.keySet()) {
            queue.offer(new Tuple(key, map.get(key)));
        }

        List<Tuple> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        return list;
    }
}
