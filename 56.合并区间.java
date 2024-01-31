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
        return mergeSimulate(intervals);
    }

    int[][] mergeSimulate(int[][] intervals) {
        // from leetcode official
        List<int[]> ans = new ArrayList<>();
        
        // sort intervals according to first element
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        
        // merge overlapped intervals
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                ans.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        // don't forget last one
        ans.add(new int[]{left, right});
        
        
        return ans.toArray(new int[0][]);
    }
}
// @lc code=end

