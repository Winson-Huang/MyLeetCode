import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] statistics = new int[26];
        Arrays.fill(statistics, 0);

        for (char C : s.toCharArray()) {
            statistics[C - 'a'] += 1;
        }

        for (char C : t.toCharArray()) {
            statistics[C - 'a'] -= 1;
        }

        for (int tmp : statistics) {
            if (tmp != 0) return false;
        }

        return true;
        
        // if String contains unicode character, int array can be 
        // replaced by a HashTable, key is int (to store Code Point). 
        // String.codePoints return a IntStream, use this stream to 
        // construct HashTable
    }
}
// @lc code=end

