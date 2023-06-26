/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    LinkedList<Integer> path;
    int[] numbers;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        numbers = nums;
        used = new boolean[numbers.length];
        Arrays.fill(used, false);

        ans = new ArrayList<>();
        path = new LinkedList<>();
        backtracking();
        return ans;
    }

    void backtracking() {
        if (path.size() == numbers.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (used[i]) {
                continue;
            }
            path.offerLast(numbers[i]);
            used[i] = true;
            backtracking();
            used[i] = false;
            path.pollLast();
        }
    }
}
// @lc code=end

