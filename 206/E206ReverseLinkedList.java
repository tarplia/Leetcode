// Source: https://leetcode.com/problems/reverse-linked-list/

public class E206ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previousNode;
            previousNode = current;
            current = temp;
        }

        return previousNode;
    }

    public void print(ListNode head) {
        ListNode current = head;

        int i = 0;
        while (current != null && i < 10) {
            System.out.print(current.val + " ");
            current = current.next;
            i++;
        }
    }

    public static void main(String[] args) {
        E206ReverseLinkedList program = new E206ReverseLinkedList();

        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);

        A.next = B;
        B.next = C;
        C.next = D;

        program.print(program.reverseList(A));
    }
}
