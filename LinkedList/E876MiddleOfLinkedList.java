class E876MiddleOfLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;

        System.out.println("Input: ");
        print(one);
        System.out.println("What's the middle node of the linkedlist? " + middleNode(one).val);

        four.next = five;
        System.out.println("Input: ");
        print(one);
        System.out.println("What's the middle node of the linkedlist? " + middleNode(one).val);
    }
}
