import java.util.ArrayList;
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
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                break;
            } else if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            } else {}

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[j] > 0 && nums[i] + nums[j] > target) {
                    break;
                } else if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                } else {}

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long)(nums[i]) + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // shortcut
                        if (nums[left] == nums[right]) {
                            break;
                        }
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

