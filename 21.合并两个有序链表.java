/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return mergeTwoListsRecursion(list1, list2);
    }
    
    // from leetcode official
    ListNode mergeTwoListsIteration(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        
        cur.next = list1 == null ? list2 : list1;

        return prehead.next;
    }

    // from leetcode official
    ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        
        // base case
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // recursion
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursion(list2.next, list1);
            return list2;
        }

    }
}
// @lc code=end

