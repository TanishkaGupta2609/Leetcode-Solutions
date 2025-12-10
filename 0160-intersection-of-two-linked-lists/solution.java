/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode h1=headA;
       ListNode h2=headB;
       int c1=0;
       int c2=0;
       while(h1!=null){
        c1++;
        h1=h1.next;
       }
       while(h2!=null){
        c2++;
        h2=h2.next;
       }
       h1=headA;
       h2=headB;
       int d;
       if(c1>c2){
        d=c1-c2;
        for(int i=0;i<d;i++){
            h1=h1.next;
        }
       }
       else{
        d=c2-c1;
          for(int i=0;i<d;i++){
            h2=h2.next;
        }
       }
   
       while(h1!=null && h2!=null){
        if(h1==h2)return h1;
        else{
            h1=h1.next;
            h2=h2.next;
        }
       } 
       return null;
    }
}
