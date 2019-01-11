package Problems;

import Structure.ListNode;

import java.util.List;

/**
 * Created by shuhanliu on 12/9/18.
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);

        head.next = node;
        node.next = node;

        ListNode ret = detectCycle2(head);

        System.out.println(ret == null ? "null" : ret.val);
    }

    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }


        ListNode slow2 = head;
        while (slow != null) {
            slow = slow.next;
            slow2 = slow2.next;
            if (slow == slow2)
                return slow;
        }

        return null;
    }

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null)
            return null;

        ListNode slow2 = head;
        while (slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }

        return slow;
    }
}
