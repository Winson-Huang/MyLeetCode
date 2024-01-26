/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagramsHash(strs);
    }

    List<List<String>> groupAnagramsHash(String[] strs) {
        // it's a bit complicated to implement a structrue with hash, so just convert the charator frequence to a string
        Map<String, List<String>> freqToWords = new HashMap<>();

        for (String word : strs) {
            String key = charFreqOfWord(word);
            if (!freqToWords.containsKey(key)) {
                freqToWords.put(key, new ArrayList<>());
            }
            List<String> words = freqToWords.get(key);
            words.add(word);
        }
        
        return new ArrayList<>(freqToWords.values());
    }
    
    // convert an array stores charactor frequence to a String
    String charFreqOfWord(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        StringBuilder freqStr = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                freqStr.append('a' + i);
                freqStr.append(freq[i]);
            }
        }
        return freqStr.toString();
    }
}
// @lc code=end

