import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    List<String> ans;
    LinkedList<String> path;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(s, 0);
        return ans;
    }

    void backtracking(String s, int startIndex) {
        if (path.size() == 4 || startIndex == s.length()) {
            if (path.size() == 4 && startIndex == s.length()) {
                ans.add(path2Str(path));
            }
            return;
        }

        if (s.charAt(startIndex) == '0') {
            path.push("0");
            backtracking(s, startIndex + 1);
            path.pop();
        } else {
            for (int i = startIndex; i < startIndex + 3; i++) {
                if (i < s.length() && Integer.valueOf(s.substring(startIndex, i+1)) < 256) {
                    path.push(s.substring(startIndex, i+1));
                    backtracking(s, i + 1);
                    path.pop();
                }
            }
        }

    }

    String path2Str(LinkedList<String> path) {
        StringBuilder sb = new StringBuilder();
        for (String s : path) {
            sb.insert(0, ".");
            sb.insert(0, s);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
// @lc code=end

