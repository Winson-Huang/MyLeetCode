import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    Deque<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(candidates, target, 0);
        return ans;
    }

    void backtracking(int[] candidates, int leftTar, int startIndex) {
        if (leftTar <= 0) {
            if (leftTar == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.push(candidates[i]);
            backtracking(candidates, leftTar - candidates[i], i);
            path.pop();
        }
    }
}
// @lc code=end

