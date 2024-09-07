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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) 
        {
            numSet.add(num);
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) 
        {
            if (numSet.contains(temp.next.val)) 
            {
                temp.next = temp.next.next;
            } 
            else 
            {
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) 
        {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
}