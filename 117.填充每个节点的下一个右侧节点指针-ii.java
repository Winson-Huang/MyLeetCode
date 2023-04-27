/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node node = root;
        while (node != null) {
            Node emptyHead = new Node(); // as a head node of next layer
            Node preNextLayer = emptyHead;
            while (node != null) {
                if (node.left != null) {
                    preNextLayer.next = node.left;
                    preNextLayer = preNextLayer.next;
                }
                if (node.right != null) {
                    preNextLayer.next = node.right;
                    preNextLayer = preNextLayer.next;
                }
                node = node.next;
            }
            node = emptyHead.next; 
        }

        return root;
    }
}
// @lc code=end

