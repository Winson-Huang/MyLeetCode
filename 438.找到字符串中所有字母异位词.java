/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return findAnagramsSlideWindow(s, p);
    }
    List<Integer> findAnagramsSlideWindow(String s, String p) {
        // from leetcode official
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        
        // build a map for p, it stores char frequence
        // difference stores different char amout between window and p
        // if window is "abc" and p is "abb", then difference is 2, because amount of b and c are both different.
        int[] charFreqP = new int[26];
        int[] charFreqWindow = new int[26];
        int difference = 0;
        for (int i = 0; i < p.length(); i++) {
            charFreqP[p.charAt(i) - 'a']++;
            charFreqWindow[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < charFreqP.length; i++) {
            if (charFreqP[i] != charFreqWindow[i]) {
                difference++;
            }
        }
        if (difference == 0) {
            ans.add(0);
        }

        // use slide window to maintain another map, when two maps equals, the substring is an anagram
        // width of window is fixed
        for (int i = p.length(); i < s.length(); i++) {
            
            int ci = s.charAt(i) - 'a';
            if (charFreqWindow[ci] == charFreqP[ci]) {
                difference++;
            }
            charFreqWindow[ci]++;
            if (charFreqWindow[ci] == charFreqP[ci]) {
                difference--;
            }
            
            int j = i - p.length();
            int cj = s.charAt(j) - 'a';
            if (charFreqWindow[cj] == charFreqP[cj]) {
                difference++;
            }
            charFreqWindow[cj]--;
            if (charFreqWindow[cj] == charFreqP[cj]) {
                difference--;
            }
            

            if (difference == 0) {
                ans.add(j + 1);
            }
        }
        
        return ans;
    }
}
// @lc code=end

