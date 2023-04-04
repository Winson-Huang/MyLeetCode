/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        // use slow and fast pointer to find middle point of list
        // use preHead pointer to point a List that may be empty
        ListNode preHead = new ListNode(-1, head);
        ListNode slow = preHead;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode preSubHead = new ListNode(-1, slow.next);
        slow.next = null;
        if(fast != null) {
           preSubHead = preSubHead.next; // length of List is even number
        }

        preSubHead = reverse(preSubHead);

        while(preHead.next != null) {
            if (preHead.next.val != preSubHead.next.val) {
                return false;
            }
            preHead = preHead.next;
            preSubHead = preSubHead.next;
        }
        return true;
    }

    ListNode reverse(ListNode prehead) {
        ListNode head = prehead.next;
        if(head == null) {
            return prehead;
        }
        ListNode pre = null;
        ListNode pointer = head;
        while(pointer.next != null) {
            ListNode tmp = pointer.next;
            pointer.next = pre;
            pre = pointer;
            pointer = tmp;
        }
        pointer.next = pre;
        prehead.next = pointer;
        return prehead;
    }
}
// @lc code=end

