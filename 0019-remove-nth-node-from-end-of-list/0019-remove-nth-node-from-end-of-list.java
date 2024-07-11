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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
        return head;
        int c=0;
        ListNode temp=head;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        if(c==n)
        {
            return head.next;
        }
        int res=c-n;
        temp=head;
        while(temp!=null)
        {
            res--;
            if(res==0)
            break;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}