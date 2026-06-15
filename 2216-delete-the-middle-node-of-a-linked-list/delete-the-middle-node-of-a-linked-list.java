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
        if(head.next == null) return null;
        ListNode curr = head,prev=null;
        ListNode newh = curr;
        int n = 0 ,i = 0;
        while(curr!=null){
            n+=1;
            curr=curr.next;
        }
        curr = head;
        while(curr!=null && i!=(n/2)){
            prev=curr;
            curr=curr.next;
            i++;
        }
        prev.next=curr.next;
        return newh;
    }
}