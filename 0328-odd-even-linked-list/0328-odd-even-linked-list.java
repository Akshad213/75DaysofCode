class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp1 = head;        // odd pointer
        ListNode temp2 = head.next;   // even pointer
        ListNode temp3 = temp2;       // save even head

        while (temp2 != null && temp2.next != null) {

            temp1.next = temp2.next;
            temp1 = temp1.next;

            temp2.next = temp1.next;
            temp2 = temp2.next;
        }

        temp1.next = temp3;

        return head;
    }
}