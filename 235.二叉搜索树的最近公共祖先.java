/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        return search(root, p, q);
    }
    TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val) {
            return search(root.right, p, q);
        } else if (q.val < root.val) {
            return search(root.left, p, q);
        } else {
            return root;
        }
    }
}
// @lc code=end

