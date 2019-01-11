package Problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuhanliu on 12/6/18.
 */
public class CopyRandomListNode {

    static class RandomListNode{
        RandomListNode next, random;
        int label;
        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode copyONSpace(RandomListNode head) {

        if (head == null)
            return head;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;

        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }

        p = head;

        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }

    public static RandomListNode copyO1Space(RandomListNode head) {

        if (head == null)
            return head;

        RandomListNode p = head;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            RandomListNode next = p.next;

            p.next = node;
            node.next = next;

            p = p .next.next;
        }

        p = head;
        while (p != null) {
            RandomListNode node = p.next;
            node.random = p.random.next;

            p = p.next.next;
        }

        p = head;
        RandomListNode newHead = p.next;

        while (p != null) {
            RandomListNode node = p.next;

            p.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }

            p = p.next;
        }


        return newHead;
    }

    public static void  printRandomList(RandomListNode head) {
        RandomListNode p = head;

        while (p != null) {
            System.out.print(p.label);
            if (p.next != null)
                System.out.print(" -> ");

            p = p.next;
        }
        System.out.println();

        p = head;
        while (p != null) {
            System.out.print(p.random.label + "    ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = n5;
        n2.random = n5;
        n3.random = n2;
        n4.random = n1;
        n5.random = n3;

        System.out.println("Original: ");
        printRandomList(n1);

        RandomListNode copy1 = copyONSpace(n1);
        System.out.println("Copy With O(n) space: ");
        printRandomList(copy1);

        RandomListNode copy2 = copyO1Space(n1);
        System.out.println("Copy With O(n) space: ");
        printRandomList(copy2);
    }
}
