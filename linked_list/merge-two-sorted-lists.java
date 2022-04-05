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
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode head = null;
        ListNode curr = null;
        
        while (n1 != null || n2 != null) {
            ListNode temp = head;
            if (n1 == null) {
                temp = n2;
                n2 = n2.next;
            } else if (n2 == null) {
                temp = n1;
                n1 = n1.next;
            } else {
                if (n1.val < n2.val) {
                    temp = n1;
                    n1 = n1.next;
                } else {
                    temp = n2;
                    n2 = n2.next;
                }
            }
            
            if (head == null) {
                head = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = curr.next;
            }
        }
        return head;
    }
}
