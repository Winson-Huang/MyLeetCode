import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> numTable = new HashMap<>();

        for (int i : nums) {
            numTable.put(i, numTable.getOrDefault(i, 0) + 1);
        }
        Integer[] keys = numTable.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        for (int i = 0; i < keys.length; i++) {
            for (int j = i; j < keys.length; j++) {
                numTable.put(keys[i], numTable.get(keys[i]) - 1);
                numTable.put(keys[j], numTable.get(keys[j]) - 1);
                Integer target = 0 - keys[i] - keys[j];
                if (
                    target >= keys[j] &&
                    numTable.get(keys[i]) >= 0 &&
                    numTable.get(keys[j]) >= 0 &&
                    numTable.getOrDefault(target, 0) > 0
                ) {
                    ans.add(Arrays.asList(keys[i], keys[j], target));
                }
                numTable.put(keys[i], numTable.get(keys[i]) + 1);
                numTable.put(keys[j], numTable.get(keys[j]) + 1);
            }
        }

        return ans;
    }
}
// @lc code=end