/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        int leftSum = 0;
        if (root.left == null) {
            leftSum = 0;
        } else if (root.left.left == null && root.left.right == null) {
            leftSum = root.left.val;
        } else {
            leftSum = sumOfLeftLeaves(root.left);
        }
        return leftSum + sumOfLeftLeaves(root.right);
    }
}
// @lc code=end

