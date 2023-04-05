/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1, head);

        ListNode preHeadReversePart = preHead;
        for (int i = 1; i < left; i++) {
            preHeadReversePart = preHeadReversePart.next;
        }

        // reverse specific part
        ListNode oldheadReversePart = preHeadReversePart.next;
        ListNode pre = null;
        ListNode curr = oldheadReversePart;
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        ListNode headLastPart = curr.next;
        curr.next = pre;

        preHeadReversePart.next = curr;
        oldheadReversePart.next = headLastPart;
        return preHead.next;
    }
}
// @lc code=end