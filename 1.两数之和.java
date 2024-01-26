import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twoSumHash(nums, target);
    }

    int[] twoSumHash(int[] nums, int target) {
        int[] ans = new int[2];
        
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        // just one scan, and ans[0] will not be same to ans[1]
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (valueToIndex.containsKey(another)) {
                ans[0] = i;
                ans[1] = valueToIndex.get(another);
                break;
            }

            valueToIndex.put(nums[i], i);
        }


        return ans;
    }
}
// @lc code=end

