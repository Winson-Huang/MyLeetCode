import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    Map<Integer, Integer> indexOfVal;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexOfVal = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexOfVal.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, 0, inorder.length);
    }
    public TreeNode buildTree(
        int[] inorder, int[] postorder, int indexIn, int indexPost, int length
    ) {
        if (length == 0) return null;

        int val = postorder[indexPost + length - 1];
        TreeNode root = new TreeNode(val);

        int indexRoot = indexOfVal.get(val);
        
        int lengthLeft = indexRoot - indexIn;

        int lengthRight = length - lengthLeft - 1;
        int indexInRight = indexRoot + 1;
        int indexPostRight = indexPost + lengthLeft;

        root.left = buildTree(inorder, postorder, indexIn, indexPost, lengthLeft);
        root.right = buildTree(inorder, postorder, indexInRight, indexPostRight, lengthRight);
        return root;
    }

}
// @lc code=end

