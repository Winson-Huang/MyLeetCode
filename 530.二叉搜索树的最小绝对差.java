/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    int minDif;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            minDif = root.val - root.left.val;
        } else if (root.right != null) {
            minDif = root.right.val - root.val;
        }
        pre = null;
        dfs(root);
        return minDif;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        if (pre != null) {
            minDif = Math.min(minDif, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
// @lc code=end

