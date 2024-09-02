/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

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
        return removeNthFromEndIteration(head, n);
    }
    /**
     * 该题目的评论区提供了一种递归解法，但需要为 class 添加一个 index 属性记录节点下标。
     */

    ListNode removeNthFromEndIteration(ListNode head, int n) {
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

    ListNode removeNthFromEndStack(ListNode head, int n) {
        
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        while (cur != null) {
            stack.offerLast(cur);
            cur = cur.next;
        }
        
        for (int i = 0; i < n; i++) {
            stack.pollLast();
        }
        
        ListNode preDel = stack.peekLast();
        preDel.next = preDel.next.next;

        return dummy.next;
    }
}
// @lc code=end

