package problem9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l) != list.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end

class PalindromeNumberTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        assertEquals(true, solution.isPalindrome(121));
        assertEquals(false, solution.isPalindrome(-121));
        assertEquals(false, solution.isPalindrome(10));
    }
}
