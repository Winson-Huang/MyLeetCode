/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    LinkedList<Integer> path;
    int[] numbers;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        numbers = nums;
        used = new boolean[numbers.length];

        backtracking();
        return ans;
    }

    void backtracking() {
        boolean[] layerUsed = new boolean[21];

        if (path.size() == numbers.length) {
            // do not add path directly
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (used[i] || layerUsed[numbers[i] + 10]) {
                continue;
            }

            path.offerLast(numbers[i]);
            used[i] = true;
            layerUsed[numbers[i] + 10] = true;

            backtracking();
            used[i] = false;
            path.pollLast();
        }
    }
}
// @lc code=end

