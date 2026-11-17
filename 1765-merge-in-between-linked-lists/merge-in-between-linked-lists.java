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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1, end = list1;
        ListNode prev = new ListNode(-1);
        ListNode parse = list2;
        int i = 0;
        while (i < a) {
            prev = start;
            start = start.next;
            i++;
        }
        i = 0;
        while (i < b) {
            end = end.next;
            i++;
        }
        while (parse.next != null) {
            parse = parse.next;
        }
        prev.next = list2;
        parse.next = end.next;
        return list1;
    }
}
