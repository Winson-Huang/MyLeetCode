import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k ;
        int lo = 0, hi = nums.length - 1;
        while ( lo < hi ) {
            int j = partition(nums, lo, hi);
            if ( j == k ) break;
            else if ( j < k ) lo = j + 1;
            else hi = j - 1; 
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while ( nums[++i] < nums[lo] && i < hi ) ;
            while ( nums[--j] > nums[lo] ) ;
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

