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
//  Time complexity -O(n)+O(n-(n%k))
// Space Complexity -O(1)

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode curr = head;
        int len=1;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }
        curr.next=head;
        k=k%len;
        k=len-k;

        while(k-- > 0) curr=curr.next;

        head=curr.next;
        curr.next=null;

        return head;
    }
}