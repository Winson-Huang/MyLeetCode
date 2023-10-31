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
        int[] ans = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (indexMap.containsKey(another)) {
                ans[0] = i;
                ans[1] = indexMap.get(another);
                break;
            }
            indexMap.put(nums[i], i);
        }
        return ans;
    }
}
// @lc code=end

