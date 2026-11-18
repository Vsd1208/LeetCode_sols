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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int grp = 1, i = 0;
        ListNode parse = head;
        ListNode start, end;
        while (parse != null) {
            i = 0;
            start = parse;
            end = parse;
            while (i < grp && parse != null) {
                end = parse;
                parse = parse.next;
                i++;
            }
            if (i % 2 == 0) {
                ListNode left = start;
                ListNode right = end;
                for (int j = 0; j < i / 2; j++) {
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                    left = left.next;
                    if (j < i / 2 - 1) {
                        ListNode prev = start;
                        while (prev.next != right) {
                            prev = prev.next;
                        }
                        right = prev;
                    }
                }
            }

            grp++;
        }
        return head;
    }
}
