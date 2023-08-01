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
        // no need to fill zero, as it is default initial value
        // scan the String to fill lastIndex
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i + 1;
        }

        // get slices
        List<Integer> sliceLen = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = lastIndex[s.charAt(0) - 'a'];
        for (int i = 1; i < s.length(); i++) {
            if (i == rightIndex) {
                sliceLen.add(rightIndex - leftIndex);
                leftIndex = i;
            }
            rightIndex = Math.max(rightIndex, lastIndex[s.charAt(i) - 'a']);
        }

        sliceLen.add(rightIndex - leftIndex);
        return sliceLen;
    }
}
// @lc code=end

