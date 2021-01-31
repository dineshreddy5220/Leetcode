/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node output=new Node(-1);
    Node pre=output;
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
        recursion(head);
        pre=pre.next;
        pre.prev=null;
        return pre;
    }
    public void recursion(Node head){
        if(head==null){
            return;
        }
        output.next=head;
        head.prev=output;
        output=output.next;
        Node next=head.next;
        if( head.child!=null){
            recursion(head.child);
            head.child=null;
        }
        recursion(next);
    }
}