/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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

    public boolean isBalanced(TreeNode root) {

        return height(root) != -1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int heightLeft = height(node.left);
        if (heightLeft == -1) {
            return -1;
        }
        int heightRight = height(node.right);
        if (heightRight == -1) {
            return -1;
        }
        if (Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        }
        return Math.max(heightLeft, heightRight) + 1;
    }
}
// @lc code=end

