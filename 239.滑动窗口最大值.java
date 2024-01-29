import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindowMonotonicQueue(nums, k);
    }
    
    
    // from leetcode official
    int[] maxSlidingWindowMonotonicQueue(int[] nums, int k) {
        MonotonicQueue numsQueue = new MonotonicQueue(nums, k);
        for (int i = 0; i < k; i++) {
            numsQueue.add(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = numsQueue.getMax();
        
        int windowLeft = 0;
        for (int windowRight = k; windowRight < nums.length; windowRight++, windowLeft++) {
            numsQueue.add(windowRight);
            numsQueue.remove(windowLeft);
            ans[windowRight - k + 1] = numsQueue.getMax();
        }
        
        return ans;
    }
    
    class MonotonicQueue {
        // monotonic queue is not exactly a "queue", in one side, it can add or remove elements to keep monotonic,
        // in the other side, it can only remove elements, so we use a Deque rather a Queue
        Deque<Integer> monotonicQ;
        int[] nums;
        public MonotonicQueue(int[] nums, int k) {
            this.monotonicQ = new ArrayDeque<>(k);
            this.nums = nums;
        }
        
        // monotonic queue stores indices
        public void add(int index) {
            while (!this.monotonicQ.isEmpty() && nums[this.monotonicQ.peekLast()] <= nums[index]) {
                this.monotonicQ.pollLast();
            }
            this.monotonicQ.offerLast(index);
        }
        
        public void remove(int index) {

            // in this problem, this case won't happen
            if (this.monotonicQ.isEmpty()) return;

            if (this.monotonicQ.peekFirst() <= index) {
                this.monotonicQ.pollFirst();
            }
        }
        
        public Integer getMax() {
            return nums[this.monotonicQ.peekFirst()];
        }
    }
    
}
// @lc code=end

