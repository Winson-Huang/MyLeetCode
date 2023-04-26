import java.util.List;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
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
            ans.add(max(arr));
        }
        return ans;
    }
    Integer max(Integer[] arr) {
        Integer ans = arr[0];
        for (Integer integer : arr) {
            if (integer > ans) {
                ans = integer;
            }
        }
        return ans;
    }
}
// @lc code=end

