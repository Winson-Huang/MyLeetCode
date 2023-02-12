/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode a = head, b = head.next;
        while (a != b) {
            if (b == null || b.next == null) return false;
            a = a.next;
            b = b.next.next;
        }
        return true;
    }
}
// @lc code=end

