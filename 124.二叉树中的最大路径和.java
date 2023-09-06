/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    // same to leetcode official solution
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    int maxPathSum = Integer.MIN_VALUE;

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int maxleft = Math.max(dfs(node.left), 0);
        int maxright = Math.max(dfs(node.right), 0);

        // for every node, find the max sum of paths which contains this node
        // and of which other part are only in this node's left subtree and right subtree
        maxPathSum = Math.max(maxPathSum, maxleft + maxright + node.val);

        return Math.max(maxleft, maxright) + node.val;
    }
}
// @lc code=end

