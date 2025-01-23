/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node temp=head;
        // Insert nodes in between
        while(temp!=null)
        {
            Node copy=new Node(temp.val);
            copy.next= temp.next;
            temp.next=copy;
            temp=temp.next.next;
        }
        temp=head;
        
        // Point the random pointers
        while(temp!=null)
        {
            Node copy=temp.next;
            if(temp.random!=null)
            copy.random=temp.random.next; // Because uske beech bhi to insert hui hogi node
            else
            copy.random=null;
            temp=temp.next.next;
        }
        
        //  Point the next pointers 
        
        Node dummy=new Node(-1);
        Node res=dummy;
        temp=head;
        while(temp!=null)
        {
            // for new cloned list
            res.next = temp.next;
            res = res.next;
            
            // reverting back previous connection
            temp.next = temp.next.next;
            temp = temp.next;
            
        }
        return dummy.next;
    }
}