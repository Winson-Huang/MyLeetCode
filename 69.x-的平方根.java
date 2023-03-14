/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h-l)/2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return sqrt;
            } else if (sqrt > mid) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h;
    }
}
// @lc code=end

