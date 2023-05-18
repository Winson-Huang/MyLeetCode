import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    LinkedList<Integer> path;
    
    public void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(n, k, 1);
        return ans;
    }
}
// @lc code=end

