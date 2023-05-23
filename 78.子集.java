import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    LinkedList<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(nums, 0);
        return ans;
    }

    void backtracking(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new LinkedList<>(path));
            return;
        }

        path.push(nums[index]);
        backtracking(nums, index + 1);
        path.pop();

        backtracking(nums, index + 1);
    }
}
// @lc code=end

