import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    Deque<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        path = new ArrayDeque<>(k);
        backtracking(k, n, 1);
        return ans;
    }

    public void backtracking(int k, int targetSum, int startI) {
        if (path.size() == k) {
            if (targetSum == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startI; i <= 9 - (k - path.size()) + 1; i++) {
            // pruning
            if (targetSum < i) {
                break;
            }
            path.offerLast(i);
            backtracking(k, targetSum - i, i + 1);
            path.pollLast();
        }
    }
}
// @lc code=end

