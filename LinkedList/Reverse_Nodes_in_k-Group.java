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
//  time complexity -O(n/k)*k --> O(n) beacause k and k together got cancled
// space complexity -O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      
      if(head==null || k==1){
          return head;
      }
      ListNode dummy = new ListNode(0);
      dummy.next=head;

      ListNode curr = dummy , prev = dummy , next = dummy;

      int count=0;
      while(curr.next!=null){
          curr = curr.next;
          count++;
      }

          while(count>=k){
              curr = prev.next;
             next = curr.next;
          for(int i=1 ; i<k ; i++){
              curr.next = next.next;
              next.next = prev.next;
              prev.next = next;
              next= curr.next;
          }
          prev = curr;
          count-=k;
      }
      return dummy.next;
    }
}