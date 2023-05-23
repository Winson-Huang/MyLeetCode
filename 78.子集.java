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
        ans.add(new LinkedList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.push(nums[i]);
            backtracking(nums, i + 1);
            path.pop();
        }
    }
}
// @lc code=end

