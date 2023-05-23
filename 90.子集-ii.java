import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    LinkedList<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(nums, 0);
        return ans;
    }

    void backtracking(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) continue;
            path.push(nums[i]);
            backtracking(nums, i+1);
            path.pop();
        }

    }
}
// @lc code=end

