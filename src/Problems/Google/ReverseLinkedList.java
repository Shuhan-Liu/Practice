package Problems.Google;

import Structure.ListNode;

/**
 * Created by shuhanliu on 2/24/19.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        reverseLinkedList(head);
    }

    public static void reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return;
        head.printAllNodes();

        ListNode p = head;
        ListNode q = head.next;
        head.next = null;

        while (q != null) {
            ListNode next = q.next;
            q.next = p;

            p = q;
            q = next;
        }

        p.printAllNodes();
    }
}
