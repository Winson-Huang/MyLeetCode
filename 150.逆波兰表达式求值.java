/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String s : tokens) {
            if (isOperator(s)) {
                int b = stack[top--];
                int a = stack[top--];
                stack[++top] = calculate(s, a, b);
            } else {
                stack[++top] = Integer.valueOf(s);
            }
        }
        return stack[0];
    }
    public int calculate(String s, int a, int b) {
        int ans = 0;
        switch (s) {
            case "+":
                ans = a + b;
                break;
            case "-":
                ans = a - b;
                break;
            case "*":
                ans = a * b;
                break;
            case "/":
                ans = a / b;
                break;
            default:
                break;
        }
        return ans;
    }

    public boolean isOperator(String s) {
        if (
            s.equals("+") ||
            s.equals("-") ||
            s.equals("*") ||
            s.equals("/")
        ) {
            return true;
        }
        return false;
    }
}
// @lc code=end

