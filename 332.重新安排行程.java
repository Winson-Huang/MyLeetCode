/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    // use TreeMap to maintain lexicographic order
    HashMap<String, TreeMap<String, Integer>> ticketsMap;
    LinkedList<String> ans = new LinkedList<>();
    int ticketsCount;

    public List<String> findItinerary(List<List<String>> tickets) {
        ticketsCount = tickets.size();

        ticketsMap = new HashMap<>();
        for (List<String> oneTicket : tickets) {
            String from = oneTicket.get(0);
            String to = oneTicket.get(1);

            TreeMap<String, Integer> destinyMap = 
            ticketsMap.getOrDefault(from, new TreeMap<>());
            destinyMap.put(to, destinyMap.getOrDefault(to, 0) + 1);

            ticketsMap.put(from, destinyMap);
        }

        ans.offerLast("JFK");
        backtracking();

        return ans;
    }

    boolean backtracking() {
        if (ans.size() == ticketsCount + 1) {
            return true;
        }

        String from = ans.peekLast();
        TreeMap<String, Integer> destinyMap = ticketsMap.get(from);
        if (destinyMap == null) return false;

        for (String to : destinyMap.keySet()) {
            int toTicketCount = destinyMap.get(to);
            if (toTicketCount == 0) {
                continue;
            }

            ans.offerLast(to);
            destinyMap.put(to, toTicketCount - 1);

            if (backtracking()) return true;

            destinyMap.put(to, toTicketCount);
            ans.pollLast();
        }

        // theoritically cannot arrive here
        return false;
    }
}
// @lc code=end

