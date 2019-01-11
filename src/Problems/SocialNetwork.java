package Problems;

import java.util.*;

/**
 * Created by shuhanliu on 10/7/18.
 *
 * http://www.1point3acres.com/bbs/thread-444226-1-1.html
 *
 */
public class SocialNetwork {
    public static void main(String[] args) {
        int[] arr12 = {3, 3, 3, 3, 3, 1, 3};
        int[] index = {0, 1, 2, 3, 4, 5, 6};
        socialGraphs(arr12);
    }

    public static void socialGraphs(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
//                System.out.println(o1.get(0) + " : " + o2.get(0));
                return o1.get(0) - o2.get(0);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (num == 1) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                queue.offer(list);
                continue;
            }

            if (!map.containsKey(num)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            } else {
                List<Integer> list = map.get(num);
                if (list.size() == num - 1) {
                    list.add(i);
                    queue.offer(list);

//                    for (Integer n : list) {
//                        System.out.print(n + " - ");
//                    }
//                    System.out.println();

                    List<Integer> newList = new ArrayList<Integer>();
                    map.put(num, newList);
                } else {
                    list.add(i);
                    map.put(num, list);
                }
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
