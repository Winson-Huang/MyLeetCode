/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // leetcode official
        
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;
        // 进位
        boolean carry = false;

        while (l1 != null || l2 != null) {

            int l1val = 0;
            if (l1 != null) {
                l1val = l1.val;
                l1 = l1.next;
            }
            
            int l2val = 0;
            if (l2 != null) {
                l2val = l2.val;
                l2 = l2.next;
            }

            int val = l1val + l2val + (carry ? 1 : 0);
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            carry = (val / 10 == 1);
        }
        
        if (carry) {
            cur.next = new ListNode(1);
            cur = cur.next;
        }
        
        return prehead.next;
    }
}
// @lc code=end

