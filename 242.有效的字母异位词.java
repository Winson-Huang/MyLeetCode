import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] stats = new int[26];

        for (char c : s.toCharArray()) {
            stats[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            stats[c - 'a']--;
        }

        boolean answer = true;
        for (int stat : stats) {
            if (stat != 0) {
                answer = false;
                break;
            }
        }

        return answer;

        // if String contains unicode character, int array can be 
        // replaced by a HashMap, key is int (to store Code Point). 
        // String.codePoints return a IntStream, use this stream to 
        // insert into HashMap
    }
}
// @lc code=end

