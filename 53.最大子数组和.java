/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    class Status {
        int lSum;
        int rSum;
        int mSum; // max sum
        int iSum; // sum of All
        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
        public Status() {}
    }

    Status get(int[] arr, int l, int r) {
        if (l==r) {
            return new Status(arr[l], arr[l], arr[l], arr[l]);
        }
        int m = (l + r) / 2;
        Status statusL = get(arr, l, m);
        Status statusR = get(arr, m+1, r);
        Status statusAll = new Status();
        statusAll.iSum = statusL.iSum + statusR.iSum;
        statusAll.lSum = Math.max(statusL.lSum, statusL.iSum + statusR.lSum);
        statusAll.rSum = Math.max(statusR.rSum, statusR.iSum + statusL.rSum);
        statusAll.mSum = Math.max(Math.max(statusL.mSum, statusR.mSum), statusL.rSum + statusR.lSum);
        return statusAll;
    }
    public int maxSubArray(int[] nums) {
        return get(nums, 0, nums.length - 1).mSum;
    }
}
// @lc code=end

