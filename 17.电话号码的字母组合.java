import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    List<String> ans;
    char[] path;
    HashMap<Character, List<Character>> nums2alpha;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }


        path = new char[digits.length()];
        nums2alpha = new HashMap<>();

        buildDict();

        backtracking(digits, 0);
        return ans;
    }

    void buildDict() {
        char digit = '2';
        char alpha = 'a';

        for (int i = 0; i < 8; i++) {
            nums2alpha.put(digit, new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                nums2alpha.get(digit).add(alpha++);
            }
            if (digit == '7' || digit == '9') {
                nums2alpha.get(digit).add(alpha++);
            }
            digit++;
        }
    }

    void backtracking(String digits, int curlen) {
        if (curlen == digits.length()) {
            ans.add(new String(path));
            return;
        }
        List<Character> chars = nums2alpha.get(digits.charAt(curlen));

        for (Character character : chars) {
            path[curlen] = character;
            backtracking(digits, curlen + 1);
        }
    }
}
// @lc code=end

