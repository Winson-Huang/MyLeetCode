/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        TreeNode parent = null;
        TreeNode node = root;

        while (node != null && key != node.val) {
            parent = node;
            node = key < node.val ? node.left : node.right;
        }
        // key is not in tree
        if (node == null) return root;

        TreeNode tmp = null;
        if (node.left == null && node.right == null) {
            tmp = null;
        } else if (node.left == null || node.right == null) {
            tmp = node.left == null ? node.right : node.left;
        } else {
            node.val = getMin(node.right);
            node.right = deleteMin(node.right);
            tmp = node;
        }

        // root.val == key
        if (parent == null) {
            return tmp;
        }

        boolean isleft = node.val < parent.val; 
        if (isleft) {
            parent.left = tmp;
        } else {
            parent.right = tmp;
        }
        return root;
    }
    
    /**
     * delete the minist node 
     * @param node the root of the tree, node is not null
     * @return the root of tree
     */
    TreeNode deleteMin(TreeNode root) {
        TreeNode node = root;
        TreeNode parent = null;
        while (node.left != null) {
            parent = node;
            node = node.left;
        }

        if (parent == null) {
            return node.right;
        }

        if (node.right == null) {
            parent.left = null;
        } else {
            parent.left = node.right;
        }

        return root;
    }

    // define a class that include TreeNode and int, get min val in deleteMin,
    // runtime will decrease.
    int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
// @lc code=end

