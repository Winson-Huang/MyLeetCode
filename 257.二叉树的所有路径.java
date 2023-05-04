/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    List<String> answer;
    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Deque<TreeNode> prefix = new ArrayDeque<>();
        dfs(root, prefix);
        return answer;
    }

    public void dfs(TreeNode node, Deque<TreeNode> prefix) {
        prefix.push(node);
        if (node.left == null && node.right == null) {
            answer.add(nodesToString(prefix));
        }

        if (node.left != null) {
            dfs(node.left, prefix);
        }
        if (node.right != null) {
            dfs(node.right, prefix);
        }

        prefix.pop();
        return;
    }

    public String nodesToString(Deque<TreeNode> path) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : path) {
            sb.insert(0, node.val);
            sb.insert(0, "->");
        }
        sb.delete(0, 2);

        return sb.toString();
    }
}
// @lc code=end

