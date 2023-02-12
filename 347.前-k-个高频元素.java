import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // word  frequence
        Map<Integer, Integer> numFrequence = new HashMap<>();
        for (int num : nums) {
            numFrequence.put(num, numFrequence.getOrDefault(num, 0) + 1);
        }

        // build buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : numFrequence.keySet()) {
            int freq = numFrequence.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(key);
        }

        // get topK
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0 && topK.size() < k; i--) {
            int need = k - topK.size();
            if (buckets[i] == null) continue;
            if (buckets[i].size() <= need) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, need));
            }
        }

        int[] res = new int[k];
        int i = 0;
        for (int item : topK) {
            res[i++] = item;
        }
        return res;
    }
}
// @lc code=end

