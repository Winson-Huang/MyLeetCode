/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        int segSize = length / k;
        int remainder = length % k;

        ListNode[] ans = new ListNode[k];
        curr = head;
        for(int i = 0; i < k && curr != null; i++) {
            ans[i] = curr;
            int curLength = segSize + (i < remainder ? 1 : 0);
            for(int j = 1; j < curLength; j++) {
                curr = curr.next;
            }
            ListNode tmp = curr.next;
            curr.next = null;
            curr = tmp;
        }
        return ans;
    }
}
// @lc code=end

