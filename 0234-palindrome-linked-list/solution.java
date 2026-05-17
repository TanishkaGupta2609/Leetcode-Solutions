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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
      ListNode slow=head;
      ListNode fast=head;
      while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
      }
      if(fast!=null){
          slow=slow.next;
      }
    ListNode cur=slow;
      ListNode prev=null;
      while(cur!=null){
          ListNode temp=cur.next;
          cur.next=prev;
          prev=cur;
          cur=temp;
      }
      ListNode first=head;
      ListNode second=prev;
     while(second!=null){
         if(first.val!=second.val){
             return false;
         }
             first=first.next;
             second=second.next;
     } 
      return true;
    }
}
