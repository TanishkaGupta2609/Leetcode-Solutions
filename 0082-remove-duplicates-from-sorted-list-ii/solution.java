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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode dummy=new ListNode(0);
       dummy.next=head;
       ListNode prev=dummy;
       ListNode cur=head;
       while(cur!=null && cur.next!=null){
        if(cur.val==cur.next.val){
            int dup=cur.val;
            while(cur!=null && cur.val==dup){
                cur=cur.next;
            }
            prev.next=cur;
        }
        else{
            prev=cur;
            cur=cur.next;
        }
       } 
       return  dummy.next;
    }
}
