package problem8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        List<Character> chList = new ArrayList<>();
        boolean positive = true;
        boolean num = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (num) {
                if (Character.isDigit(ch)) {
                    chList.add(ch);
                } else {
                    break;
                }
            } else {
                if (ch == '+' || ch == '-') {
                    if (ch == '-') {
                        positive = false;
                    }
                    num = true;
                } else if (Character.isDigit(ch)) {
                    chList.add(ch);
                    num = true;
                } else if (!Character.isWhitespace(ch)) {
                    return 0;
                }
            }
        }
        int ans = 0;
        int maxDivideTen = Integer.MAX_VALUE / 10;
        for (char ch : chList) {
            int n = Character.getNumericValue(ch);
            if (!positive && ans == maxDivideTen && n == 8) {
                return Integer.MIN_VALUE;
            }
            if (ans > maxDivideTen || (ans == maxDivideTen && n > 7)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans *= 10;
            ans += n;
        }
        return positive ? ans : -ans;
    }
}
// @lc code=end

class StringToIntegerAtoiTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        assertEquals(42, solution.myAtoi("42"));
        assertEquals(-42, solution.myAtoi("   -42"));
        assertEquals(4193, solution.myAtoi("4193 with words"));
        assertEquals(2147483647, solution.myAtoi("   2147483647 with words"));
        assertEquals(-2147483648, solution.myAtoi("   -2147483648 with words"));
        assertEquals(2147483647, solution.myAtoi("   2147483648 with words"));
        assertEquals(-2147483648, solution.myAtoi("   -2147483649 with words"));
    }
}
