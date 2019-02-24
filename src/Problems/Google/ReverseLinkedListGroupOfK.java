package Problems.Google;

import Structure.ListNode;

/**
 * Created by shuhanliu on 2/24/19.
 */
public class ReverseLinkedListGroupOfK {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        ListNode head = new ListNode(arr);

        System.out.println("BEGIN:");
        head.printAllNodes();

//        ListNode newHead = reverseKGroup(head, 3);
        ListNode newHead = reverseKGroupSimplified(head, k);

        System.out.println("END:");
        newHead.printAllNodes();
    }

    public static ListNode reverseKGroupSimplified(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevTail = dummy;

        ListNode start = head;
        ListNode end = head;
        int count = 1;

        while (end != null) {
            if (count == k) {

                ListNode next = end.next;

                prevTail.next = null;
                end.next = null;

                reverseListSimple(start);

                prevTail.next = end;
                start.next = next;

                prevTail = start;
                start = next;
                end = next;
                count = 1;
            } else {
                end = end.next;
                count ++;
            }
        }

        return dummy.next;
    }

    public static void reverseListSimple(ListNode start) {
        if (start == null || start.next == null)
            return;

        ListNode p = start;
        ListNode q = start.next;
        start.next = null;

        while (q != null) {
            ListNode next = q.next;
            q.next = p;

            p = q;
            q = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = head;

        ListNode newHead = head;
        ListNode start = head;
        ListNode end = head;


        int count = 1;
        boolean started = false;


        while (end != null) {
            System.out.println("IN PROCESS:");
            newHead.printAllNodes();
            if (count == k) {
                ListNode next = end.next;
                end.next = null;

                ListNode n = reverseList(start);
                tail.next = n;
                tail = start;
                if (!started) {
                    newHead = n;
                    started = true;
                }

                start.next = next;
                start = next;
                end = start;
                count = 1;
            } else {
                end = end.next;
                count++;
            }
        }

        return newHead;
    }

    public static ListNode reverseList(ListNode start) {
        if (start == null || start.next == null)
            return start;

        ListNode p = start;
        ListNode q = start.next;
        start.next = null;

        while (q != null) {
            ListNode next = q.next;
            q.next = p;

            p = q;
            q = next;
        }

        return p;
    }


}
