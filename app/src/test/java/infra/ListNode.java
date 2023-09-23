package infra;
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createFrom(int[] nums) {
        ListNode head = new ListNode();
        ListNode curr = head;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        System.out.print('[');
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
            if (curr != null) {
                System.out.print(", ");
            }
        }
        System.out.print(']');
    }
}
