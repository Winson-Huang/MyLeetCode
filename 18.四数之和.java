import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 4) return ans;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (
                nums[i] >= target && nums[i] > 0
            ) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i+1; j < nums.length - 2; j++) {
                if (
                    nums[i] + nums[j] >= target &&
                    (nums[j] > 0)
                ) {
                    break;
                }

                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ans.add(Arrays.asList(
                            nums[i], nums[j], nums[left], nums[right]
                        ));

                        // if there are many same numbers in array, this shortcut save time
                        if (nums[left] == nums[right]) break;

                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;

                        left++;
                        right--;
                    }
                }

            }

        }

        return ans;
    }
}
// @lc code=end

