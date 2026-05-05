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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        Queue<ListNode> q = new LinkedList<>();
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        k = k % len;
        if(k == 0) return head;
        temp = head;
        for(int i = 0; i < len - k; i++){
            q.offer(temp);
            temp = temp.next;
        }
        ListNode newHead = temp;
        ListNode curr = newHead;
        while(curr.next != null){
            curr = curr.next;
        }
        while(!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
        }
        curr.next = null;
        return newHead;
    }
}