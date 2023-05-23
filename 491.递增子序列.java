import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    LinkedList<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(nums, 0);
        return ans;

    }

    void backtracking(int[] nums, int startIndex) {
        boolean[] used = new boolean[201];

        if (path.size() > 1) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (
                used[nums[i] + 100] || 
                (!path.isEmpty() && nums[i] < path.peekLast())
            ) {
                continue;
            }
            used[nums[i] + 100] = true;
            path.offerLast(nums[i]);
            backtracking(nums, i+1);
            path.pollLast();
        }
        
    }
}
// @lc code=end

