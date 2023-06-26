import java.util.ArrayList;
import java.util.Arrays;
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
    int[] numbers;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        numbers = nums;
        backtracking(0);
        return ans;
    }

    void backtracking(int startIndex) {
        boolean[] used = new boolean[201];
        Arrays.fill(used, false);

        if (path.size() > 1) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < numbers.length; i++) {
            if (
                (!path.isEmpty() && path.peekLast() > numbers[i]) ||
                used[numbers[i] + 100]
            ) {
                continue;
            }
            path.offerLast(numbers[i]);
            used[numbers[i] + 100] = true;
            backtracking(i+1);
            path.pollLast();
        }

        return;
    }

}
// @lc code=end

