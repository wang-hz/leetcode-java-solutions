package problem10;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatchCore(s, p, i, j - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (isMatchCore(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[slen][plen];
    }

    private boolean isMatchCore(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
// @lc code=end

class RegularExpressionMatchingTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        assertFalse(solution.isMatch("aa", "a"));
    }

    @Test
    void case2() {
        assertTrue(solution.isMatch("aa", "a*"));
    }

    @Test
    void case3() {
        assertTrue(solution.isMatch("ab", ".*"));
    }
}
