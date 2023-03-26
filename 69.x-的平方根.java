/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {

    /**
     * 注意到所求结果 ans 实际上是满足如下条件的值：
     * ans * ans <= x && (ans + 1) * (ans + 1) > x
     * 也就是找到最大的 ans 使得 ans 的平方不大于 x
     * 二分法用于不断逼近 ans 的上界
     * 当一个 mid 的平方不大于 x 时，需要判断 mid + 1 及其右侧是否还存在满足条件的值，
     * 如果都不满足，则只会进入第二个分支而不会更新 ans 的值，最终输出的 ans 是正确的。
     * 如果右侧有满足条件的值，则相当于又发现了一个满足条件的 mid，那么问题又变成了判断
     * mid + 1 及其右侧是否还存在满足条件的值。
     */
    public int mySqrt(int x) {
        int l = 0, r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if ( (long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

