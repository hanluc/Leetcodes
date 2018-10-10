/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        return merge(lists, 0, lists.length);
            
    }
    
    private ListNode merge(ListNode[] lists, int beg, int end){
        if ( beg >= end )
            return null;
        if ( beg + 1 == end )
            return lists[beg];
        
        if ( beg + 2 == end )
            return merge2Lists(lists[beg], lists[end-1]);
        
        int mid = (beg + end)/2;
        lists[beg] = merge(lists, beg, mid);
        lists[mid] = merge(lists, mid, end);
        
        return merge2Lists(lists[beg], lists[mid]);
        
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur = cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            cur = cur.next = l1;
        if (l2 != null)
            cur = cur.next = l2;
        
        return dummy.next;
        
    }
}