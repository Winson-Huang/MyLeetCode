import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int iLength = intervals.length;
        if (iLength == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1);
            }
        });
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < iLength; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return iLength - count;
    }
}
// @lc code=end

