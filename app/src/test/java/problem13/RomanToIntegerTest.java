package problem13;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            char first = s.charAt(i);
            char second = i > 0 ? s.charAt(i - 1) : 0;
            if (first == 'M') {
                ans += 1000;
                if (second == 'C') {
                    ans -= 100;
                    i--;
                }
            } else if (first == 'D') {
                ans += 500;
                if (second == 'C') {
                    ans -= 100;
                    i--;
                }
            } else if (first == 'C') {
                ans += 100;
                if (second == 'X') {
                    ans -= 10;
                    i--;
                }
            } else if (first == 'L') {
                ans += 50;
                if (second == 'X') {
                    ans -= 10;
                    i--;
                }
            } else if (first == 'X') {
                ans += 10;
                if (second == 'I') {
                    ans -= 1;
                    i--;
                }
            } else if (first == 'V') {
                ans += 5;
                if (second == 'I') {
                    ans -= 1;
                    i--;
                }
            } else if (first == 'I') {
                ans += 1;
            }
            i--;
        }
        return ans;
    }
}
// @lc code=end

