/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode temp=head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            if(fast.next!=null)
            fast=fast.next.next;
        }
        boolean result=true;
        ListNode reverse=reverse(slow);
        ListNode reverse2=reverse;
        while(reverse!=null && temp!=null){
            if(reverse.val!=temp.val){
                result=false;
                break;
            }
            reverse=reverse.next;
            temp=temp.next;
        }
        return result;
    }
    public ListNode reverse(ListNode node){
        ListNode prev=null;
        while(node!=null){
            ListNode next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
}
