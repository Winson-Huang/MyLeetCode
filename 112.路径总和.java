/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        traversal(root, targetSum);
        return ans;
    }
    public void traversal(TreeNode node, int residualSum) {
        if (ans == true) return;
        residualSum -= node.val;
        if (
            node.left == null && node.right == null && 
            residualSum == 0
        ) {
            ans = true;
            return;
        }
        if (node.left != null) {
            traversal(node.left, residualSum);
        }
        if (node.right != null) {
            traversal(node.right, residualSum);
        }
        return;
    }
}
// @lc code=end

