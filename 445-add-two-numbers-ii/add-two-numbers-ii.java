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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> s2 = new Stack<>();
        while(l2 != null){
            s2.push(l2.val);   
            l2 = l2.next;
        }
        Stack<Integer> s3 = new Stack<>();
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int num1 = 0, num2 = 0;
            if(!s1.isEmpty()) num1 = s1.pop();
            if(!s2.isEmpty()) num2 = s2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        if(carry != 0) s3.push(carry);
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!s3.isEmpty()){
            curr.next = new ListNode(s3.pop());
            curr = curr.next;
        }
        return head.next;
    }
}