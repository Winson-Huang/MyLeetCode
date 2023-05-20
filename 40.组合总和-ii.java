import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    Deque<Integer> path;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(candidates);
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
            if (candidates[i] > leftTar) break;
            if (i > startIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.push(candidates[i]);
            backtracking(candidates, leftTar - candidates[i], i + 1);
            path.pop();
        }
    }
}
// @lc code=end

