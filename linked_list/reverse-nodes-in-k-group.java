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
    
    class KGroup {
        ListNode head;
        ListNode tail;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        KGroup prev = null;
        while (head != null) {
            Deque<ListNode> deque = new ArrayDeque<>();
            for (int i = 0; i < k && head != null; i++) {
                deque.addLast(head);
                head = head.next;
            }
            if (deque.size() != k) {
                if (prev != null) {
                    prev.tail.next = deque.pollFirst();
                }
                return newHead;
            }
            KGroup cur = reverseGroup(deque);
            if (newHead == null) {
                newHead = cur.head;
            }
            if (prev != null) {
                prev.tail.next = cur.head;
            }
            cur.tail.next = null;
            prev = cur;
        }
        return newHead;
    }
    
    public KGroup reverseGroup(Deque<ListNode> deque) {
        ListNode cur = deque.pollLast();
        KGroup result = new KGroup();
        result.head = cur;
        while (!deque.isEmpty()) {
            cur.next = deque.pollLast();
            cur = cur.next;
        }
        result.tail = cur;
        return result;
    }
}
