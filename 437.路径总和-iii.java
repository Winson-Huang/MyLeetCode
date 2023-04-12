import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        findPath(root, 0, targetSum, prefix);
        return ans;
    }
    public void findPath(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefix) {
        if (node == null) return;
        currSum += node.val;
        // because path must contain 1 node at least 
        // and targetSum may be zero, 
        // so must update ans before update prefix
        ans += prefix.getOrDefault(currSum - targetSum, 0);

        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        findPath(node.left, currSum, targetSum, prefix);
        findPath(node.right, currSum, targetSum, prefix);
        prefix.put(currSum, prefix.get(currSum) - 1);
    } 
}
// @lc code=end

