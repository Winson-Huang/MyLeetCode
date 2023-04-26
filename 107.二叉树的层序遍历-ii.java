import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>(ans);
        }

        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            Integer[] arr = new Integer[que.size()];
            for (int i = 0; i < arr.length; i++) {
                TreeNode tmp = que.poll();
                arr[i] = tmp.val;
                if (tmp.left != null) {
                    que.offer(tmp.left);
                }
                if (tmp.right != null) {
                    que.offer(tmp.right);
                }
            }

            ans.offerFirst(Arrays.asList(arr));
        }

        return new ArrayList<>(ans);
    }
}
// @lc code=end

