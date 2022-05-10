/* Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * Approach: Using Fast and Slow Pointers.
 * (1) Detect the cycle as seen in Leetcode 141.
 * (2) After two pointers meet, move one pointer to the head and
 * move both pointers with the same speed until they meet again.
 * (3) The meeting point is the head of the cycle.
 */

public class M142LinkedListCycleII {
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        // Find the head of the cycle
        slow = head;
        while (slow != fast && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        System.out.println("What's the head of the cycle? " + detectCycle(one).val);
    }
}
