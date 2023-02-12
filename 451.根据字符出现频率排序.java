import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        char[] schrArr = s.toCharArray();
        // frequence count
        int maxFreq = 0;
        Map<Character, Integer> chrFreq = new HashMap<>();
        for (Character c : schrArr) {
            int freq = chrFreq.getOrDefault(c, 0) + 1;
            chrFreq.put(c, freq );
            maxFreq = Math.max(maxFreq, freq);
        }
        // build buckets
        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        for (Map.Entry<Character, Integer> entry : chrFreq.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new StringBuilder();
            }
            buckets[freq].append(entry.getKey());
        }

        // get string
        StringBuilder reStr = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            if (buckets[i] == null) continue;
            StringBuilder bucket = buckets[i];
            for (int j = 0; j < bucket.length(); j++) {
                for (int k = 0; k < i; k++) {
                    reStr.append(bucket.charAt(j));
                }
            }
        }
        return reStr.toString();
    }
}
// @lc code=end

