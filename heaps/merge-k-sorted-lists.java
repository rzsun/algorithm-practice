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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            lists.length, new NodeComparator());
        
        for (ListNode n : lists) {
            while (n != null) {
                heap.offer(n);
                n = n.next;
            }
        }
        
        ListNode root = heap.poll();
        ListNode prev = root;
        if (prev == null) {
            return null;
        }
        
        ListNode cur = prev;
        while (cur != null) {            
            cur = heap.poll();
            prev.next = cur;
            prev = cur;
        }
        
        return root;
    }
    
    static class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}
