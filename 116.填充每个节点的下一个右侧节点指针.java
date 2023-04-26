import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
        while (node.left != null) {
            Node tmp = node; // tmp for this layer traversal
            while (tmp != null) {
                tmp.left.next = tmp.right;
                tmp.right.next = tmp.next == null ? null : tmp.next.left;
                tmp = tmp.next;
            }
            node = node.left;
        }
        return root;
    }
}
// @lc code=end

