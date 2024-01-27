import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTwoPointers(nums);
    }
    // from leetcode official
    public List<List<Integer>> threeSumTwoPointers(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            } else if (i > 0 && nums[i - 1] == nums[i]) {
                // for removing duplicates in answer
                continue;
            } else {
                int j = i + 1, k = nums.length - 1;
                // use two pointers to find all (j, k)
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        j++;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        // this is a shortcut
                        if (nums[j] == nums[k]) {
                            break;
                        }

                        // for removing duplicates in answer
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                        while (j < k && nums[k - 1] == nums[k]) {
                            k--;
                        }
                        k--;
                    }
                }
            }
        }

        return ans;
    }
}
// @lc code=end