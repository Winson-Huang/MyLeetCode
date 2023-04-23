import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
    Deque<Integer> que;

    public MyStack() {
        que = new ArrayDeque<>();
    }
    
    public void push(int x) {
        que.offer(x);
    }
    
    public int pop() {
        for (int i = 0; i < que.size() - 1; i++) {
            que.offer(que.poll());
        }
        return que.poll();
    }
    
    public int top() {
        return que.peekLast();
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

