/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int maxSum = 0;

        // step 1, flip all negative value, or run out of k 
        while (k > 0 && i < nums.length && nums[i] < 0) {
            nums[i] = -nums[i];
            maxSum += nums[i];
            k--;
            i++;
        }

        // step 2, if really run out of k, just add left elements.
        // Or if all elements are positive now and still have k, 
        // pick the minimium value and process, then add left elements.
        if (k == 0) {
            while (i < nums.length) {
                maxSum += nums[i];
                i++;
            }
        } else {
            int minValue = Arrays.stream(nums).summaryStatistics().getMin();
            if (k % 2 == 1) {
                maxSum -= 2 * minValue;
            } 
            while (i < nums.length) {
                maxSum += nums[i];
                i++;
            }
        }
        return maxSum;
    }
}
// @lc code=end

