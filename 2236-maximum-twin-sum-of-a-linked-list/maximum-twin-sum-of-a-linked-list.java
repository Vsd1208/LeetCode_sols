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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        int[] arr = new int[length];
        curr = head;
        int i = 0;
        while(curr != null){
            arr[i++] = curr.val;
            curr = curr.next;
        }
        int max = Integer.MIN_VALUE;
        for(i = 0; i < length/2; i++){
            max = Math.max(max, arr[i] + arr[length - i - 1]);
        }
        return max;
    }
}