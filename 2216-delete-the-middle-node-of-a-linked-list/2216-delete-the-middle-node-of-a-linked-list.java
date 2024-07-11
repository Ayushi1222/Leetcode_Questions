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
    public ListNode deleteMiddle(ListNode head) {
        if(head== null || head.next==null)
        return head.next;
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next.next;//So that wo ek pehle hi ruk jaye (middle se ek pehle) so that we can delete that.
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next = slow.next.next; 
        return head;
    }
}