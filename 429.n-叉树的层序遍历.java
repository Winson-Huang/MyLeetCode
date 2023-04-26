import java.util.Queue;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            Integer[] arr = new Integer[que.size()];
            for (int i = 0; i < arr.length; i++) {
                Node tmp = que.poll();
                arr[i] = tmp.val;

                for (Node child: tmp.children) {
                    que.offer(child);
                }
            }

            ans.add(Arrays.asList(arr));
        }
        return ans;
    }
}
// @lc code=end

