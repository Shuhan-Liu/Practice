package Structure;

/**
 * Created by shuhanliu on 12/9/18.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        if (arr.length > 0) {
            int i = 0;
            this.val = arr[0];
            ListNode p = this;
            for (i = 1; i < arr.length; i++) {
                p.next = new ListNode(arr[i]);
                p = p.next;
            }
        }
    }

    public void printAllNodes() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print("->");
            }
            p = p.next;
        }
        System.out.println();
    }
}
