/* Given the head of a singly linked list, return true if it is a palindrome.
 *
 */
public class E234PalindromeLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode rev = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rev;
    }

    public static void main(String[] args) {
        // Test a palindrome linkedlist.
        ListNode D = new ListNode(1);
        ListNode C = new ListNode(2, D);
        ListNode B = new ListNode(2, C);
        ListNode A = new ListNode(1, B);

        System.out.println("Is the linkedlist a palindrome? " + isPalindrome(A));

        // Test a non-palindrome linkedlist.
        ListNode F = new ListNode(2);
        ListNode E = new ListNode(1, F);

        System.out.println("Is the linkedlist a palindrome? " + isPalindrome(E));

        // Test an empty linkedlist.
        System.out.println("Is the linkedlist a palindrome? " + isPalindrome(new ListNode()));
    }
}
