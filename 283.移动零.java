/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        moveZeroesTwoPointers(nums);
    }

    
    void moveZeroesTwoPointers(int[] nums) {
        int indexToPut = 0;
        int indexToScan = 0;

        while (indexToScan < nums.length) {
            if (nums[indexToScan] == 0) {
                indexToScan++;
                continue;
            }
            nums[indexToPut] = nums[indexToScan];
            indexToPut++;
            indexToScan++;
        }
        
        while (indexToPut < nums.length) {
            nums[indexToPut] = 0;
            indexToPut++;
        }
    }
}
// @lc code=end

