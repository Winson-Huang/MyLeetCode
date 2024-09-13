/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;



class Solution {
    Map<Node, Node> old2new = new HashMap<>();

    public Node copyRandomList(Node head) {
        // return copyRandomListRecursion(head);
        return copyRandomListIteration(head);
    }

    // hashtable
    Node copyRandomListRecursion(Node head) {
        if (head == null) {
            return null;
        }
        if (old2new.get(head) == null) {
            Node newHead = new Node(head.val);
            old2new.put(head, newHead);

            newHead.next = copyRandomListRecursion(head.next);
            newHead.random = copyRandomListRecursion(head.random);
        }
        return old2new.get(head);
    }

    Node copyRandomListIteration(Node head) {
        if (head == null) return null;
        // create new nodes
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        
        // link random
        node = head;
        while (node != null) {
            Node next = node.next;
            next.random = node.random == null ? null : node.random.next;
            node = next.next;
        }
        
        // split new list
        node = head;
        head = head.next;
        while (node != null) {
            Node next = node.next;
            node.next = node.next.next;
            next.next = next.next == null ? null : next.next.next;
            node = node.next;
        }

        return head;
    }
}
// @lc code=end

