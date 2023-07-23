/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    class Status {
        int lSum; // max sum of subseq start from left
        int rSum; // max sum of subseq end in right
        int mSum; // max sum of subseq
        int aSum; // sum of all elements
    }

    Status get(int[] nums, int left, int right) {
        Status ss = new Status();
        if (left == right) {
            ss.lSum = ss.rSum = ss.mSum = ss.aSum = nums[left];
            return ss;
        }

        // in this case, left + right wont overflow, 
        // but it's better to write as left + (right - left) / 2
        int mid = (left + right) >> 1;

        Status sleft = get(nums, left, mid);
        Status sright = get(nums, mid + 1, right);

        ss.lSum = Math.max(sleft.lSum, sleft.aSum + sright.lSum);
        ss.rSum = Math.max(sright.rSum, sright.aSum + sleft.rSum);
        ss.mSum = Math.max(sleft.rSum + sright.lSum, Math.max(sleft.mSum, sright.mSum));
        ss.aSum = sleft.aSum + sright.aSum;
        return ss;
    }

    public int maxSubArray(int[] nums) {
        return get(nums, 0, nums.length - 1).mSum;
    }
}
// @lc code=end

