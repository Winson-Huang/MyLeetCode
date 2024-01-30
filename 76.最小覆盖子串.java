/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        return minWindowTwoPointers(s, t);
    }
    
    // from leetcode official, but only use one map
    String minWindowTwoPointers(String s, String t) {
        // use hash map to store charator frequence
        Map<Character, Integer> charFreq = new HashMap<>();
        for (Character ct : t.toCharArray()) {
            charFreq.put(ct, charFreq.getOrDefault(ct, 0) + 1);
        }
        
        
        int ansLen = s.length() + 1;
        int ansLeftIndex = -1;
        // move right pointer, until it include all char in t
        int leftPointer = 0;
        int rightPointer = 0;
        while (rightPointer < s.length()) {
            Character cs = s.charAt(rightPointer);
            if (charFreq.containsKey(cs)) {
                charFreq.put(cs, charFreq.get(cs) - 1);
            }
            rightPointer++;
            

            // then move left pointer, as far as it can
            while (isNegativeOrZero(charFreq)) {
                // record tmp ans
                if (rightPointer - leftPointer < ansLen) {
                    ansLen = rightPointer - leftPointer;
                    ansLeftIndex = leftPointer;
                }
                

                cs = s.charAt(leftPointer);
                if (charFreq.containsKey(cs)) {
                    charFreq.put(cs, charFreq.get(cs) + 1);
                }
                leftPointer++;
            }
        }
        
        return ansLeftIndex == -1 ? "" : s.substring(ansLeftIndex, ansLeftIndex + ansLen);
    }
    
    // if all value in charFreq is not positive, substring will cover t
    boolean isNegativeOrZero(Map<Character, Integer> charFreq) {
        for (Integer freq : charFreq.values()) {
            if (freq > 0) return false;
        }
        return true;
    }
    
}
// @lc code=end

