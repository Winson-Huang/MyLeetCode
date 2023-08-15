/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] is the max length of increasing subseq that ends with nums[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // when get a max length, record it
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }
        return maxLen;
    }
}
// @lc code=end

