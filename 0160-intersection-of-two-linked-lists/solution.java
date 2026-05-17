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
        if(headA==null)return headB;
        if(headB==null)return headA;
        int lenA=0;
        int lenB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null){
            tempA=tempA.next;
            lenA++;
        }
        while(tempB!=null){
            tempB=tempB.next;
            lenB++;
        }
        tempA=headA;
        tempB=headB;
        while(lenA>lenB){
            tempA=tempA.next;
            lenA--;
        }
        while(lenB>lenA){
            tempB=tempB.next;
            lenB--;
        }
        while(tempA!=null && tempB!=null){
            if(tempA==tempB){
                return tempA;
            }
            else{
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }
        return null;
    }
}
