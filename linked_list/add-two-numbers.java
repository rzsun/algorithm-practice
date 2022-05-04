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
        ListNode head = null;
        ListNode prev = null;
        
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int result = carry;
            if (l1 != null) {
                result += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result += l2.val;
                l2 = l2.next;
            }
            
            carry = result / 10;
            result = result % 10;
            
            ListNode cur = new ListNode(result);
            if (head == null) {
                head = cur;
            }
            if (prev != null) {
                prev.next = cur;
            }
            prev = cur;
        }
        return head;
    }
}
