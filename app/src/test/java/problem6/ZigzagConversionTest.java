package problem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int m = numRows - 1;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= m; i++) {
            for (int j = i; j < n; j += 2 * m) {
                sb.append(s.charAt(j));
                if (i != 0 && i != m) {
                    int k = j + 2 * (m - i);
                    if (k < n) {
                        sb.append(s.charAt(k));
                    }
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

class ZigzagConversionTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
    }

    @Test
    void case2() {
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
    }

    @Test
    void case3() {
        assertEquals("A", solution.convert("A", 1));
    }
}
