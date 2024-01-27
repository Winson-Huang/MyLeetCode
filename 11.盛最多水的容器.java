/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        return maxAreaTwoPointers(height);
    }

    int maxAreaTwoPointers(int[] height) {
        // from leetcode official
        // when height[left] < height[right], all candidate right borders at left side of "right" won't be in solution
        // space, so the "left" should step right.
        int maxVolume = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int heightOfWater = 0;
            int widthOfWater = 0;
            if (height[left] < height[right]) {
                heightOfWater = height[left];
                widthOfWater = right - left;
                left++;
            } else {
                heightOfWater = height[right];
                widthOfWater = right - left;
                right--;
            }
            maxVolume = Math.max(maxVolume, widthOfWater * heightOfWater);
        }

        return maxVolume;
    }
}
// @lc code=end

