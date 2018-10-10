/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prehead = new ListNode(0);
        ListNode p = prehead;                  //don't forget to add the type of p
        
        while( l1 != null || l2 != null){       //compress the process of adding l1 or l2 tail into main loop
            int x = (l1 == null)? 0 : l1.val;
            int y = (l2 == null)? 0 : l2.val;
            int sum = x + y + carry;
            ListNode digit = new ListNode(sum % 10);
            p = p.next = digit;    //sure, i can write like this
            carry = sum / 10;
            if( l1 != null ) l1 = l1.next;
            if( l2 != null ) l2 = l2.next;
        }
        
        //don't forget to handle the remainders--carry
        if( carry != 0){
            p.next = new ListNode(carry);
        }
        
        return prehead.next;
        
    }
}