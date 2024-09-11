/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroupTwoPointers(head, k);
    }

    public ListNode reverseKGroupTwoPointers(ListNode head, int k) {
        // this problem is a combination of "linked list reversion" and 
        // "linked list iteraion"
        ListNode dummy = new ListNode(0, head);
        // preHead will be updated iteratively
        ListNode preHead = dummy;
        ListNode node = head;
        while (node != null) {
            int i = 0;
            for (i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            // now, nodes between preHead(ex) and node(ex) should be reversed
            if (i == k) {
                preHead = reverse(preHead, k);
                preHead.next = node;
            } else {
                break;
            }
        }
        return dummy.next;
    }
    ListNode reverse(ListNode preHead, int k) {
        // the caller will make sure preHead have more than k suffix
        // return the tail node
        ListNode pre = preHead;
        ListNode node = preHead.next;
        ListNode tail = node;
        for (int i = 0; i < k; i++) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        preHead.next = pre;
        return tail;
    }

    

    public ListNode reverseKGroupStack(ListNode head, int k) {
        return head;
    }

    public ListNode reverseKGroupRecursion(ListNode head, int k) {
        return head;
    }
}
// @lc code=end

