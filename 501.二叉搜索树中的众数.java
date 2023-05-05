import java.util.Deque;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    Deque<Integer> maxCountNum;
    TreeNode pre;
    int tmpmax;
    int count;
    public int[] findMode(TreeNode root) {
        maxCountNum = new ArrayDeque<>();
        pre = null;
        tmpmax = 0;
        count = 0;

        dfs(root);

        int[] ans = new int[maxCountNum.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = maxCountNum.pop();
        }
        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (pre != null && root.val == pre.val) {
            count++;
        } else {
            count = 1;
        }
        pre = root;

        if (count > tmpmax) {
            tmpmax = count;
            maxCountNum.clear();
            maxCountNum.push(root.val);
        } else if (count == tmpmax) {
            maxCountNum.push(root.val);
        }

        dfs(root.right);
    }
}
// @lc code=end

