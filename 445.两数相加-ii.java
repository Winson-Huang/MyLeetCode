import java.util.Stack;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
        Stack<ListNode> l1Stack = makeStack(l1);
        Stack<ListNode> l2Stack = makeStack(l2);

        ListNode preHead = new ListNode(-1, null);
        int carry = 0;
        while(!l1Stack.empty() || !l2Stack.empty() || carry != 0) {
            int x1 = l1Stack.empty()? 0 : l1Stack.pop().val;
            int x2 = l2Stack.empty()? 0 : l2Stack.pop().val;
            int sum = x1 + x2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum, preHead.next);
            preHead.next = tmp;
        }
        return preHead.next;
    }

    Stack<ListNode> makeStack(ListNode head) {
        Stack<ListNode> result = new Stack<>();
        while(head != null) {
            result.push(head);
            head = head.next;
        }
        return result;
    }
}
// @lc code=end

