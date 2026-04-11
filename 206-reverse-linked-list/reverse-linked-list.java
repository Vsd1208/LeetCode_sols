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
    public ListNode reverseList(ListNode head) {
        // ListNode prev = null;
        // ListNode curr = head;
        // while (curr != null) {
        //     ListNode nextNode = curr.next; 
        //     curr.next = prev;           
        //     prev = curr;                   
        //     curr = nextNode;               
        // } 
        // return prev; // new head
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        while(curr!=null){
            st.push(curr.val);
            curr=curr.next;
        }
        ListNode rev = new ListNode(0);
        ListNode r = rev;
        while(!st.isEmpty()){
            ListNode newnode = new ListNode(st.pop());
            rev.next=newnode;
            rev=rev.next;
        }
        return r.next;
    }
}