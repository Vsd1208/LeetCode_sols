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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr != null) {
            sum += curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }
        sum = 0;
        curr = dummy;

        while (curr != null) {
            sum += curr.val;

            curr.next = map.get(sum).next;

            curr = curr.next;
        }

        return dummy.next;
    }
}