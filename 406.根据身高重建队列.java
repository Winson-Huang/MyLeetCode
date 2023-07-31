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
                return p1[0] == p2[0] ? p2[1] - p1[1] : p1[0] - p2[0];
            }
        });

        // faster than LinkedList
        // init in this way, element in allNulls is null (allNulls[0] == null is true)
        int[][] allNulls = new int[people.length][];
        // element in ArrayList is allowed to be null
        List<int[]> queue = new ArrayList<>(Arrays.asList(allNulls));

        for (int[] oneperson: people) {
            int index = 0;
            int countNull = oneperson[1];
            while (countNull >= 0) {
                if (queue.get(index++) == null) {
                    countNull--;
                }
            }

            queue.set(--index, oneperson);
        }

        return queue.toArray(new int[people.length][2]);
    }

}
// @lc code=end

