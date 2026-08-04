// ListNode dummy = new ListNode(-1);
        // ListNode merged = dummy;
        // ListNode l1 = list1;
        // ListNode l2 = list2;
        // while(l1 != null && l2 !=null){
        //     if(l1.val <= l2.val){
        //         merged.next = l1;
        //         l1=l1.next;
        //     }
        //     else{
        //         merged.next = l2;
        //         l2=l2.next;
        //     }
        //     merged=merged.next;
        // }
        // if (l1 != null) merged.next = l1;
        // if (l2 != null) merged.next = l2;
        // return dummy.next;
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n1 = new ListNode(-1);
        ListNode dummy = n1;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                n1.next=list1;
                list1=list1.next;
            }
            else {
                n1.next=list2;
                list2=list2.next;
            }
            n1=n1.next;
        }
        if(list1!=null) n1.next=list1;
        if(list2!=null) n1.next=list2;
        n1=n1.next;
        return dummy.next;
    }
}