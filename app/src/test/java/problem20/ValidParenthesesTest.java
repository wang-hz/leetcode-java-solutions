package problem20;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (stack.empty()) {
                return false;
            } else {
                char left = stack.pop();
                if ((left == '(' && ch != ')') || (left == '[' && ch != ']') || (left == '{' && ch != '}')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
// @lc code=end

class ValidParenthesesTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertFalse(solution.isValid("(]"));
    }
}
