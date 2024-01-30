/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {

    public int maxSubArray(int[] nums) {
        // return maxSubArrayDp(nums);
        return maxSubArrayDivideConquer(nums);
    }

    // dp is more interpretable than greedy
    // from leetcode official
    int maxSubArrayDp(int[] nums) {
        int maxSumEndsAtI = nums[0];
        int maxSum = maxSumEndsAtI;
        
        for (int i = 1; i < nums.length; i++) {
            maxSumEndsAtI = Math.max(maxSumEndsAtI + nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxSumEndsAtI);
        }
        
        return maxSum;
    }
    

    // divide and conquer is more powerful (but no better in time and space)
    int maxSubArrayDivideConquer(int[] nums) {
        return getStatus(nums, 0, nums.length - 1).maxSum;
    }
    
    class Status {
        int lmSum;  // max sum of subseq start from left  
        int rmSum;  // max sum of subseq end in right    
        int maxSum; // max sum of subseq                 
        int sum;    // sum of all elements               
    }
    
    Status getStatus(int[] nums, int left, int right) {
        Status status = new Status();
        // in fact, this case won't happen
        if (left > right) {
            status.lmSum = status.rmSum = status.maxSum = status.sum = 0;
            return status;
        }
        if (left == right) {
            status.lmSum = status.rmSum = status.maxSum = status.sum = nums[left];
            return status;
        }
        
        // in this case, left + right wont overflow, 
        // but it's better to write as left + (right - left) / 2
        int mid = (left + right) >> 1;
        
        Status leftStatus = getStatus(nums, left, mid);
        Status righStatus = getStatus(nums, mid + 1, right);
        status.lmSum = Math.max(leftStatus.lmSum, leftStatus.sum + righStatus.lmSum);
        status.rmSum = Math.max(righStatus.rmSum, leftStatus.rmSum + righStatus.sum);
        status.maxSum = Math.max(leftStatus.rmSum + righStatus.lmSum,
            Math.max(leftStatus.maxSum, righStatus.maxSum));
        status.sum = leftStatus.sum + righStatus.sum;
        
        return status;
    }
}
// @lc code=end

