/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // [left, right] is a candidate interval in result
        int left = intervals[0][0];
        int right = intervals[0][1];

        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                result.add(new int[] {left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(right, intervals[i][1]);
            }
        }

        result.add(new int[] {left, right});
        return result.toArray(new int[0][]);
    }
}
// @lc code=end

