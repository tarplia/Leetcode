/* Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */

class M92ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

//     // Recursive
//     public static ListNode reverseBetween(ListNode head, int left, int right) {
//         if (left <= 1) {
//             // You can also expand the code here to get rid of the helper function 'reverseN'
//             return reverseN(head, right - left + 1);
//         }
//         head.next = reverseBetween(head.next, left - 1, right - 1);
//         return head;
//     }

//     ListNode successor = null;

//     private static ListNode reverseN(ListNode head, int n) {
//         if (n == 1) {
//             successor = head.next;
//             return head;
//         }
//         ListNode last = reverseN(head.next, n - 1);
//         head.next.next = head;
//         head.next = successor;
//         return last;
//     }

    // Iterative
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode end = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = end.next;
            end.next = pre.next;
            pre.next = end;
            end = start.next;
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        ListNode current = head;

        int i = 0;
        while (current != null && i < 10) {
            System.out.print(current.val + " ");
            current = current.next;
            i++;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;

        // Reverse between nodes.
        System.out.println("Before: ");
        print(A);
        int start = 2;
        int end = 4;
        System.out.println("After reversing " + start + " to " + end + ":");
        print(reverseBetween(A, start, end));
        end = 5;
        System.out.println("After reversing " + start + " to " + end + ":");
        print(reverseBetween(A, start, end));
    }
}
