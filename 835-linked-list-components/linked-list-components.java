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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums) set.add(n);
        ListNode current = head;
        int comp=0;
        ListNode prev = null;
        while(current!=null){
            if (set.contains(current.val) && (prev == null || !set.contains(prev.val))) {
                comp++;
            }
            prev=current;
            current=current.next;
        }
        return comp;
    }
}