/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringSlideWindow(s);
    }

    int lengthOfLongestSubstringSlideWindow(String s) {
        // slide window and hashtable, from leetcode official and improvement in comments

        // use a hashmap to store last index of an charactor.
        // when window end comes to the s end, we will get the answer.

        int windowLeft = -1;
        int ans = 0;
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int windowRight = 0; windowRight < s.length(); windowRight++) {
            Character cToProc = s.charAt(windowRight);

            // if last index of current charactor key is in the window, it means there is a duplicated char in window now.
            if (lastIndex.containsKey(cToProc) && lastIndex.get(cToProc) > windowLeft) {
                windowLeft = lastIndex.get(cToProc);
                ans = Math.max(ans, windowRight - windowLeft);
            }

            lastIndex.put(cToProc, windowRight);
        }

        return ans;
    }
}
// @lc code=end

