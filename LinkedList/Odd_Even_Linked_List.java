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
//  time complexity - O(n)
// space Complexity -O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd=head;
        ListNode even = head.next;

        ListNode evenHead = even;

        while(even!=null && even.next!=null){

            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;

        }
        odd.next = evenHead;
        return head;       
    }
}