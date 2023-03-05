import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        int pointsLength = points.length;
        if (pointsLength == 0) 
            return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < pointsLength; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

