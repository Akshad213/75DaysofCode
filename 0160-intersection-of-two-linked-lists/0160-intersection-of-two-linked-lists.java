/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode temp = headA;
       ListNode temp2 = headB;
       int n1 =0;
       while(temp != null){
        n1++;
        temp = temp.next;
       }
       temp = headA;
       int n2 =0;
       while(temp2 != null){
        n2++;
        temp2 = temp2.next;
       }
       temp2 = headB;
       if(n1 < n2){
        int diff = n2 -n1;
        while(diff !=0){
            diff--;
           temp2 = temp2.next;
        }
       }
       else{
        int diff = n1-n2;
          while(diff !=0){
            diff--;
           temp = temp.next;
       }
       }
        while(temp != null && temp2 != null){
        if(temp == temp2){
            return temp;
        }
        temp = temp.next;
        temp2 = temp2.next;
       }
      return null;
    
    }
}