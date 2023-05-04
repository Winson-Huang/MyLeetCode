import java.util.Deque;

/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // values in nums are identical
        Deque<Integer> stack = new ArrayDeque<>();

        int length = nums.length;
        int[] leftIndex = new int[length];
        int[] rightIndex = new int[length];
        Arrays.fill(leftIndex, -1);
        Arrays.fill(rightIndex, -1);

        // fill leftIndex and rightIndex
        TreeNode[] treenodeArr = new TreeNode[length];
        for (int i = 0; i < length; i++) {
            treenodeArr[i] = new TreeNode(nums[i]);

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                rightIndex[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                leftIndex[i] = stack.peek();
            }
            stack.push(i);
        }

        // build tree
        TreeNode root = null;
        for (int i = 0; i < length; i++) {
            if (leftIndex[i] == -1 && rightIndex[i] == -1) {
                root = treenodeArr[i];
            } else if (
                leftIndex[i] == -1 || 
                (rightIndex[i] != -1 && nums[leftIndex[i]] > nums[rightIndex[i]])
            ) {
                treenodeArr[rightIndex[i]].left = treenodeArr[i];
            } else {
                treenodeArr[leftIndex[i]].right = treenodeArr[i];
            }
        }

        return root;
    }
}
// @lc code=end

