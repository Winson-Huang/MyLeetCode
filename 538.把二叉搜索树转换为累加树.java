/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root) {
        if (root.right != null) {
            dfs(root.right);
        }
        root.val = root.val + preSum;
        preSum = root.val;
        if (root.left != null) {
            dfs(root.left);
        }
    }
}
// @lc code=end

