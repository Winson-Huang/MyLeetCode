/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if need delete an item, having a dummy is helpful
        ListNode dummy = new ListNode(-1, head);

        // let probeTail go ahead n item, then probeTail and preTodelete go ahead
        // simultaneously, when probeTail in tail, preTodelete.next is to be deleted
        ListNode probeTail = dummy;
        for (int i = 0; i < n; i++) {
            probeTail = probeTail.next;
        }

        ListNode tmpPre = dummy;
        while (probeTail.next != null) {
            probeTail = probeTail.next;
            tmpPre = tmpPre.next;
        }
        tmpPre.next = tmpPre.next.next;

        return dummy.next;
    }
}
// @lc code=end

