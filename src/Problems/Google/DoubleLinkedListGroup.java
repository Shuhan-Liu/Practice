package Problems.Google;

import Structure.DoubleNode;

import java.util.*;

/**
 * Created by shuhanliu on 1/19/19.
 *
 * 一长双向链表和一个节点数组（无序）存着这个链表中一部分节点，
 * 要求找出数组中的节点能分成几组， 组的定义是 如果节点是相邻的，
 * 那么他们就是在一个组里面。
 *
 * Followup：怎么自动生成他的测试数据（要求写一段code表示），
 * 如果这个数组改成一个数据流（没固定长度）， 问取n次数据， 组的数目分别是多少
 */
public class DoubleLinkedListGroup {

    private static Random random = new Random();
    private static int range = 100;

//    public static void main (String[] args) {
//        int len = 10;
//        int count = 5;
//        DoubleNode head = constructList(len);
//        DoubleNode[] arr = constructRandomArr(head, count, len);
//        printDoubleList(head);
//        printDoubleNodeArr(arr);
//        List<List<DoubleNode>> ret = groupNode(head, arr);
//        for (List<DoubleNode> list : ret) {
//            System.out.print("[ ");
//            for (DoubleNode n : list) {
//                System.out.print(n.val + " ");
//            }
//            System.out.println("]");
//        }
//
//    }

//    public static List<List<DoubleNode>> groupNode(DoubleNode head, DoubleNode[] arr) {
//
//        List<List<DoubleNode>> ret = new ArrayList<>();
//        Map<DoubleNode, List<DoubleNode>> map = new HashMap<>();
//
//        for (DoubleNode node : arr) {
//            if (map.containsKey(node.prev)) {
//                map.get(node.prev).add
//            } else {
//                map.put(node, new ArrayList<>());
//                map.get(node).add(node);
//            }
//        }
//
//        return ret;
//    }

    public static void printTestList(List<DoubleNode> list) {
        System.out.println("LIST:::");
        for (DoubleNode node : list) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static List<DoubleNode> merge(Set<List<DoubleNode>> set) {
        List<DoubleNode> ret = new ArrayList<>();
        for (List<DoubleNode> list : set) {
            for (DoubleNode node : list) {
                ret.add(node);
            }
        }
        return ret;
    }

    public static void printDoubleNodeArr(DoubleNode[] arr) {
        for (DoubleNode node : arr) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static DoubleNode[] constructRandomArr(DoubleNode head, int count, int len) {
        DoubleNode[] arr = new DoubleNode[count];
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(len);
            DoubleNode p = head;
            while(p!=null && index > 0) {
                p = p.next;
                index--;
            }
            arr[i] = p;
        }
        return arr;
    }

    public static void printDoubleList(DoubleNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static DoubleNode constructList(int len) {
        DoubleNode dummy = new DoubleNode(0);
        DoubleNode p = dummy;

        for (int i = 0; i < len; i++) {
            DoubleNode cur = new DoubleNode(random.nextInt(range));
            cur.prev = p;
            p.next = cur;
            p = cur;
        }

        dummy.next.prev = null;
        return dummy.next;
    }

//    public static List<List<DoubleNode>> groupNode(DoubleNode head, DoubleNode[] arr) {
//        Map<DoubleNode, List<DoubleNode>> map = new HashMap<>();
//        Map<DoubleNode, List<DoubleNode>> need = new HashMap<>();
//
//        List<List<DoubleNode>> ret = new ArrayList<>();
//        for (DoubleNode node : arr) {
//
//            DoubleNode prev = node.prev;
//            DoubleNode next = node.next;
//            if (prev != null) {
//                if (!need.containsKey(prev)) {
//                    need.put(prev, new ArrayList<>());
//                }
//                need.get(prev).add(node);
//            }
//
//            if (next != null) {
//                if (!need.containsKey(next)) {
//                    need.put(next, new ArrayList<>());
//                }
//                need.get(next).add(node);
//            }
//
//            if (need.containsKey(node)) {
//                List<DoubleNode> list = need.get(node);
//                need.remove(node);
//
//                boolean existList = false;
//
//                Set<List<DoubleNode>> existed = new HashSet<>();
//                for (DoubleNode n : list) {
//                    if (map.containsKey(n)) {
//                        existList = true;
//                        existed.add(map.get(n));
//                        break;
//                    }
//                }
//
//                List<DoubleNode> tmp = merge(existed);
//                printTestList(tmp);
//                tmp.add(node);
//                printTestList(tmp);
//
//                if (!existList) {
//                    list.add(node);
//                    ret.add(list);
//                }
//
//                for (DoubleNode n : list) {
//                    if (!map.containsKey(n)) {
//                        map.put(n, list);
//                    }
//                }
//
//            }
//        }
//        return ret;
//    }
}
