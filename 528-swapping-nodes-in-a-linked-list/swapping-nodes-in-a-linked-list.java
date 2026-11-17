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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = head;
        ListNode sn = null;
        ListNode end = head;
        ListNode en = null;

        int i = 0;
        int l = 0;

        while (start != null) {
            start = start.next;
            l++;
        }

        start = head;

        while (i < k - 1) {
            sn = start;
            start = start.next;
            i++;
        }

        i = 0;

        while (i < l - k) {
            en = end;
            end = end.next;
            i++;
        }

        if (start == end) return head;
        if (start.next == end) {
            if (sn != null) sn.next = end;
            else head = end;

            start.next = end.next;
            end.next = start;
        }
        else if (end.next == start) {
            if (en != null) en.next = start;
            else head = start;

            end.next = start.next;
            start.next = end;
        }
        else {
            if (sn != null) sn.next = end;
            else head = end;

            if (en != null) en.next = start;
            else head = start;

            ListNode temp = start.next;
            start.next = end.next;
            end.next = temp;
        }

        return head;
    }
}
