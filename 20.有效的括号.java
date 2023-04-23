/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if ((s.length() & 1) == 1) return false;

        Stack<Character> leftStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    leftStack.push(')');
                    break;
                case '{':
                    leftStack.push('}');
                    break;
                case '[':
                    leftStack.push(']');
                    break;
                default:
                    if (
                        !leftStack.isEmpty() &&
                        leftStack.peek().equals(s.charAt(i))
                    ) {
                        leftStack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return leftStack.isEmpty();
    }

}
// @lc code=end

