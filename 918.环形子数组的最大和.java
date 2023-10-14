/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // There are 3 solutions in official post.
        // The "monotonic queue" is a very interesting solution.

        // This monotonic queue stores element indices
        Deque<int[]> monotonicq = new ArrayDeque<>();
        int answer = nums[0];
        int preSum = nums[0];
        monotonicq.offerLast(new int[]{0, preSum});
        for (int i = 1; i < 2 * nums.length; i++) {
            while (monotonicq.peekFirst()[0] < i - nums.length) {
                // in official post, it test whether monotonicq is empty,
                // but in fact don't need to do it, monotonicq will never be empty here.
                // 在 for 循环开始时，队列中有一个元素，且该元素不满足 while 循环的条件。
                // 在第 2 次以及之后的每次迭代中，队列中至少有上次迭代的最后一步添加的那个元素，而
                // 而这个元素也必然不满足本 while 循环的条件。
                monotonicq.pollFirst();
            }
            preSum += nums[i % nums.length];
            answer = Math.max(answer, preSum - monotonicq.peekFirst()[1]);
            while (!monotonicq.isEmpty() && monotonicq.peekLast()[1] >= preSum) {
                monotonicq.pollLast();
            }
            monotonicq.offerLast(new int[]{i, preSum});
        }

        return answer;
    }
}
// @lc code=end

