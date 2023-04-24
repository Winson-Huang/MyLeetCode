import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Stack<String> dirs = new Stack<>();
        final String curPos = ".";
        final String parentPos = "..";

        int i = 0;
        while (i < path.length()) {
            // find word between two '/'
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            int j = i;
            while (j < path.length() && path.charAt(j) != '/') {
                j++;
            }

            String tmp = path.substring(i, j);
            i = j;

            if (tmp.equals(curPos) || tmp.equals("")) {
                continue;
            } else if (tmp.equals(parentPos)) {
                if (!dirs.isEmpty()) {
                    dirs.pop();
                }
            } else {
                dirs.push(tmp);
            }
        }

        if (dirs.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : dirs) {
            sb.append("/");
            sb.append(dir);
        }
        return sb.toString();
    }

}
// @lc code=end

