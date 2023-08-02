/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
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
    class Status {
        // put a camera in root, and cover all nodes
        int a;

        // cover all nodes, no matter if a camera in root
        int b;

        // do not need to cover root, cover other nodes
        int c;

        public Status(int a, int b, int c) {
            this.a = a; this.b = b; this.c = c;
        }
    }

    public Status dfs(TreeNode node) {
        if (node == null) {
            return new Status(Integer.MAX_VALUE / 2, 0, 0);
        }

        Status left = dfs(node.left);
        Status right = dfs(node.right);

        int a = 1 + left.c + right.c;
        int b = Math.min(a, Math.min(left.a + right.b, left.b + right.a));
        int c = Math.min(b, left.b + right.b);

        return new Status(a, b, c);
    }



    public int minCameraCover(TreeNode root) {
        return dfs(root).b;
    }
}
// @lc code=end

