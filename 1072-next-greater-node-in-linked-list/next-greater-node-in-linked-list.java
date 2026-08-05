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
    private int length(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public int[] nextLargerNodes(ListNode head) {
        int len = length(head),index=0;
        int[] arr = new int[len];
        int[]n_max = new int[len];
        ListNode curr = head;
        while(curr!=null){
            arr[index++] = curr.val;
            curr=curr.next;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int val = stack.pop();
                n_max[val] = arr[i];
            }
            stack.push(i);
        }
        return n_max;
    }
}