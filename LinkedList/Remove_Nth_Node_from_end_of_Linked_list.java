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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      if(head==null || head.next==null){
          return null;
      }
    //   calculate size of the linked list
      int size=0;
      ListNode curr = head;
      while(curr!=null){
          curr=curr.next;
          size++;
      }
    //   we return head next because if n is == size then indirecty we delete the head that why we return head.next 
      if(n==size){
          return head.next;
      }
      //here we search previous node of deleted node
      int indexToSearch = size-n;
      ListNode prev = head;
      int i=1;
      while(i<indexToSearch){
          prev=prev.next;
          i++;
      }
    //   3->5
      prev.next=prev.next.next;
      return head;     
    }
}