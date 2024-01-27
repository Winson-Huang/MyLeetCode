/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        return longestConsecutiveHash(nums);
    }

    int longestConsecutiveHash(int[] nums) {
        // from leetcode official
        // just use hashset to store elements in nums
        Set<Integer> numsEle = new HashSet<>();
        for (Integer num : nums) {
            numsEle.add(num);
        }
        
        // calculate maxLen
        int maxLen = 0;
        for (Integer num : nums) {
            if (numsEle.contains(num - 1)) {
                continue;
            }
            int i = 1;
            while (numsEle.contains(i + num)) {
                i++;
            }
            maxLen = Math.max(maxLen, i);
        }
        
        return maxLen;
    }
}
// @lc code=end

