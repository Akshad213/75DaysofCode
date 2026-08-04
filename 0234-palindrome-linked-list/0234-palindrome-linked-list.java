/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reversell(ListNode mid){
        ListNode prev = null;
        ListNode temp = mid;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;

        }
        return prev;
    }
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null &&fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
       if(head == null || head.next == null){
        return true;
       }
      ListNode mid = findMid(head);
      ListNode newhead = reversell(mid);

        ListNode first = head;
        ListNode last = newhead;
        while(last != null){
            if(first.val != last.val){
                return false;
            }
            first = first.next;
            last = last.next;

        }
        return true;



    }
}