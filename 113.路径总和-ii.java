import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> answer;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answer = new ArrayList<>();
        if (root == null) return answer;
        LinkedList<Integer> path = new LinkedList<>();
        traversal(root, targetSum, path);
        return answer;
    }

    public void traversal(TreeNode node, int targetSum, LinkedList<Integer> path) {
        targetSum -= node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && targetSum == 0) {
            // path is just a pointer, dont add it directly
            answer.add(new ArrayList<>(path));
        }
        if (node.left != null) {
            traversal(node.left, targetSum, path);
        }
        if (node.right!= null) {
            traversal(node.right, targetSum, path);
        }

        path.removeLast();
        return;
    }
}
// @lc code=end

