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
        Set<ListNode> listNodesA = new HashSet<>();
        ListNode tmpPtr = headA;
        while (tmpPtr != null) {
            listNodesA.add(tmpPtr);
            tmpPtr = tmpPtr.next;
        }
        tmpPtr = headB;
        while (tmpPtr != null) {
            if (listNodesA.contains(tmpPtr)) {
                return tmpPtr;
            }
            tmpPtr = tmpPtr.next;
        }
        return null;
    }
}
// @lc code=end

