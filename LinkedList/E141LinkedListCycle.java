/* Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * Approach: Using Fast and Slow Pointer.
 * If the two pointers meet, that means cycle is detected, otherwise no cycle.
*/

public class E141LinkedListCycle {
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
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

        System.out.println("Does the linkedlist has cycle? " + hasCycle(one));
    }
}
