/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start


class Solution {
    public void rotate(int[] nums, int k) {
        rotateReverse(nums, k);
    }
    
    

    
    // from leetcode
    void rotateReverse(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k , nums.length);
    }
    
    void reverse(int[] arr, int start, int end) {
        // from start(inclusive) to end(exclusive)
        if (start < 0 || end > arr.length) return;
        for (int i = 0; i < (end - start) / 2; i++) {
            int tmp = arr[end - i - 1];
            arr[end - i - 1] = arr[start + i];
            arr[start + i] = tmp;
        }
    }
    
}
// @lc code=end

