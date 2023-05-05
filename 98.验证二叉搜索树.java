/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    boolean answer;
    public boolean isValidBST(TreeNode root) {
        answer = true;
        // according to problem desc, root is not null
        isValidBST(root, null, null);
        return answer;
    }

    // make sure root is not null
    public void isValidBST(TreeNode root, TreeNode left, TreeNode right) {
        if (answer == false) return;

        if (
            (left != null && root.val <= left.val) ||
            (right != null && root.val >= right.val) 
        ) {
            answer = false;
            return;
        }

        if (root.left != null) {
            isValidBST(root.left, left, root);
        }
        if (root.right != null) {
            isValidBST(root.right, root, right);
        }
    }
}
// @lc code=end

