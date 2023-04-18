import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer, Integer> indexOfNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (indexOfNums.containsKey(key)) {
                ans[0] = i;
                ans[1] = indexOfNums.get(key);
                break;
            }
            indexOfNums.put(nums[i], i);
        }
        return ans;
    }
}
// @lc code=end

