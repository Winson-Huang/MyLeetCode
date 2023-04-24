import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    class DiminishQueue {
        Deque<Integer> deque;
        public DiminishQueue(int k) {
            this.deque = new ArrayDeque<>(k);
        }

        public void push(int value) {
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public void pop(int value) {
            if (deque.isEmpty()) return; // this case wont appear
            if (deque.peekFirst() == value) {
                deque.pollFirst();
            }
        }

        public int frontValue() {
            return deque.peekFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        DiminishQueue diminishQueue = new DiminishQueue(k);
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            diminishQueue.push(nums[i]);
        }
        ans[0] = diminishQueue.frontValue();

        for (int i = 1; i < ans.length; i++) {
            diminishQueue.pop(nums[i - 1]);
            diminishQueue.push(nums[k + i - 1]);
            ans[i] = diminishQueue.frontValue();
        }
        return ans;
    }
}
// @lc code=end

