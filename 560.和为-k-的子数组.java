/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        return subarraySumPreSum(nums, k);
    }

    // from leetcode official, pre sum and hash
    int subarraySumPreSum(int[] nums, int k) {
        int preSum = 0;
        Map<Integer, Integer> preSumToCount = new HashMap<>();
        preSumToCount.put(0, 1);
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            count += preSumToCount.getOrDefault(preSum - k, 0);

            preSumToCount.put(preSum, preSumToCount.getOrDefault(preSum, 0) + 1);
        }
        
        return count;
    }
}
// @lc code=end

