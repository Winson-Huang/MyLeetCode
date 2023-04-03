/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1, head);
        ListNode tmpPre = preHead;
        while(tmpPre.next != null && tmpPre.next.next != null) {
            ListNode first = tmpPre.next, second = tmpPre.next.next;
            first.next = second.next;
            second.next = first;
            tmpPre.next = second;
            tmpPre = first;
        }
        return preHead.next;
    }
}
// @lc code=end

