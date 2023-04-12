/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
    int ans = -1;
    int rootVal = -1;

    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootVal) {
            ans = node.val;
        } 
        dfs(node.left);
        dfs(node.right);
    }

}
// @lc code=end

