import java.util.Queue;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            depth++;
            int length = que.size();
            for (int i = 0; i < length; i++) {
                Node node = que.poll();
                for (Node child : node.children) {
                    que.offer(child);
                }
            }
        }
        return depth;
        
    }
}
// @lc code=end

