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
    private int length(ListNode node){
        int count=0;
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode node = head;
        int len = length(node);
        int rem = len%k,part=len/k;
        ListNode[] parts = new ListNode[k];
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            parts[i] = current;
            int size = part + (rem > 0 ? 1 : 0);
            if (rem > 0) rem--;
            if (current == null) continue;
            for (int j = 1; j < size; j++) {
                current = current.next;
            }
            ListNode next = current.next;
            current.next = null;
            current = next;
        }
        return parts;
    }
}