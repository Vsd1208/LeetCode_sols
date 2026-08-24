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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int l=length(head);
        if(l<3) return new int[]{-1,-1};
        int[] arr=new int[l];
        ListNode temp=head;
        for(int i=0;i<l;i++){
            arr[i]=temp.val;
            temp=temp.next;
        }
        List<Integer> cri=new ArrayList<>();
        for(int i=1;i<l-1;i++){
            if(arr[i-1]<arr[i]&&arr[i]>arr[i+1]){
                cri.add(i);
            }
            else if(arr[i-1]>arr[i]&&arr[i]<arr[i+1]){
                cri.add(i);
            }
        }
        if(cri.size()<2) return new int[]{-1,-1};
        int min=Integer.MAX_VALUE;
        for(int i=1;i<cri.size();i++){
            min=Math.min(min,cri.get(i)-cri.get(i-1));
        }
        int max=cri.get(cri.size()-1)-cri.get(0);
        return new int[]{min,max};
    }
}