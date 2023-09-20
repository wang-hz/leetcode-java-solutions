package problem5;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int[] ans = {0, 1};
        int n = s.length();
        for (int i = 1; i < n; i++) {
            ans = longestPalindromeCore(s, i, i, ans);
            ans = longestPalindromeCore(s, i - 1, i, ans);
        }
        return s.substring(ans[0], ans[1]);
    }

    private static int[] longestPalindromeCore(String s, int i, int j, int[] ans) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return ans[1] - ans[0] < j - i - 1 ? new int[]{i + 1, j} : ans;
    }
}
// @lc code=end

class LongestPalindromicSubstringTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        System.out.println(solution.longestPalindrome("babad"));
    }

    @Test
    void case2() {
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
