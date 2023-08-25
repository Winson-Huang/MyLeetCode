/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // build a map from value to index in nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        // use monotonic stack to scan nums2
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                if (map.containsKey(stack.peek())) {
                    result[map.get(stack.peek())] = nums2[i];
                }
                stack.pop();
            }
            stack.push(nums2[i]);
        }

        return result;
    }
}
// @lc code=end

