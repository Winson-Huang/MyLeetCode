/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    class Node {
        int x;
        Node next;
        public Node(int x, Node next) {
            this.x = x;
            this.next = next;
        }
    }
    Node head = null;
    Node tail = null;

    public MyQueue() {

    }
    
    public void push(int x) {
        if (tail == null) {
            head = tail = new Node(x, null);
        } else {
            tail.next = new Node(x, null);
            tail = tail.next;
        }
        return;
    }
    
    public int pop() {
        int ans = head.x;
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return ans;
    }
    
    public int peek() {
        return head.x;
    }
    
    public boolean empty() {
        return head == null;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end