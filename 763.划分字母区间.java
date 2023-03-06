import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        // lastIndex-1 is the last index of a char
        // if s doesnot contains some char, these char's lastIndex is 0
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < 26; i++) {
            lastIndexOfChar[i] = 0;
        }

        // scan the string
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[s.charAt(i) - 'a'] = i + 1;
        }

        // get result 
        List<Integer> sliceLens = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = lastIndexOfChar[s.charAt(0) - 'a'];
        for (int i = 1; i < s.length(); i++) {
            if (i == rightIndex) {
                sliceLens.add(rightIndex - leftIndex);
                leftIndex = i;
            }
            rightIndex = Math.max(
                rightIndex,
                lastIndexOfChar[s.charAt(i) - 'a']
            );
        }
        sliceLens.add(rightIndex - leftIndex);
        return sliceLens;
    }
}
// @lc code=end

