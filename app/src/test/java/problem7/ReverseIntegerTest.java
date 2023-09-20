package problem7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        boolean positive = true;
        if (x < 0) {
            x = -x;
            positive = false;
        }
        int a = 0;
        int int_max_d10 = Integer.MAX_VALUE / 10;
        while (x > 0) {
            int r = x % 10;
            if (a > int_max_d10 || (a == int_max_d10 && r > 7)) {
                return 0;
            }
            a *= 10;
            a += r;
            x /= 10;
        }
        return positive ? a : -a;
    }
}
// @lc code=end

class ReverseIntegerTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        assertEquals(321, solution.reverse(123));
    }

    @Test
    void case2() {
        assertEquals(-321, solution.reverse(-123));
    }

    @Test
    void case3() {
        assertEquals(21, solution.reverse(120));
    }

    @Test
    void case4() {
        assertEquals(0, solution.reverse(Integer.MIN_VALUE));
    }

    @Test
    void case5() {
        System.out.println(solution.reverse(Integer.MAX_VALUE));
        System.out.println(solution.reverse(Integer.MIN_VALUE));
    }
}
