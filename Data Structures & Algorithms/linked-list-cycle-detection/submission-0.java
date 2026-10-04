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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode s = head.next;
        ListNode f = head.next.next;

        while (f != null) {
            if (s.val == f.val) {
                return true;
            }
            s = s.next;
            if (f.next == null) {
                return false;
            }
            else {
                f = f.next.next;
            }
        }
        return false;
    }
}
