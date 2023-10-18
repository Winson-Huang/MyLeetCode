import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 代码随想录解法，不如双指针优雅
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        
        if (lenA < lenB) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;
            ListNode tmpHead = headA;
            headA = headB;
            headB = tmpHead;
        }

        curA = headA;
        curB = headB;
        for (int i = 0; i < lenA - lenB; i++) {
            curA = curA.next;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
// @lc code=end

