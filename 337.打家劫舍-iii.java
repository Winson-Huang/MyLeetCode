/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Status {
        int selectedValue = 0;
        int unSelectedValue = 0;
        public int max() {
            return Math.max(selectedValue, unSelectedValue);
        }
    }
    public int rob(TreeNode root) {
        return dfs(root).max();
    }

    public Status dfs(TreeNode node) {
        if (node == null) {
            return new Status();
        }
        Status leftStatus = dfs(node.left);
        Status rightStatus = dfs(node.right);
        
        Status status = new Status();

        status.selectedValue = node.val + leftStatus.unSelectedValue + rightStatus.unSelectedValue;
        status.unSelectedValue = leftStatus.max() + rightStatus.max();

        return status;
    }
}
// @lc code=end

