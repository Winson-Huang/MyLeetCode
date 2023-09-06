/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * search the tree to find longest path from node to its subtree
     * that all node value in this path are same
     * @param node
     * @return the length of this longest path
     */
    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftLen = dfs(node.left);
        int rightLen = dfs(node.right);

        if (node.left != null && node.val == node.left.val) {
            leftLen++;
        } else {
            leftLen = 0;
        }

        if (node.right != null && node.val == node.right.val) {
            rightLen++;
        } else {
            rightLen = 0;
        }

        ans = Math.max(leftLen + rightLen, ans);

        return Math.max(leftLen, rightLen);
    }

}
// @lc code=end

