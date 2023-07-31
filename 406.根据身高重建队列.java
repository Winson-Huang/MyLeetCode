import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });

        // faster than LinkedList
        List<int[]> queue = new ArrayList<>();
        for (int[] oneperson: people) {
            queue.add(oneperson[1], oneperson);
        }

        return queue.toArray(new int[people.length][2]);
    }
}
// @lc code=end

