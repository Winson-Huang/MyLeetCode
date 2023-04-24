import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // topK and K-th Element can both solved by:
        // QuickSort(N*logN), PriorityQueue(N*logk), Quickselect(N), BucketSort(N)
        // but BucketSort can only used in discrete values.

        // PriorityQueue
        class Node implements Comparable {
            int num;
            int freq;

            public Node(int num, int freq) {
                this.num = num;
                this.freq = freq;
            }
            @Override
            public int compareTo(Object o) {
                return freq - ((Node)o).freq;
            }
        }

        // word frequence
        Map<Integer, Integer> numFrequence = new HashMap<>();
        for (int num : nums) {
            numFrequence.put(num, numFrequence.getOrDefault(num, 0) + 1);
        }

        // default is minHeap
        Queue<Node> pq = new PriorityQueue<>(k + 1);
        Integer[] keys = numFrequence.keySet().toArray(new Integer[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(keys[i], numFrequence.get(keys[i])));
        }
        for (int i = k; i < keys.length; i++) {
            pq.offer(new Node(keys[i], numFrequence.get(keys[i])));
            pq.poll();
        }

        // get topK
        int[] ans = new int[pq.size()];
        int i = 0;
        for (Node node : pq) {
            ans[i++] = node.num;
        }

        return ans;
    }
}
// @lc code=end

