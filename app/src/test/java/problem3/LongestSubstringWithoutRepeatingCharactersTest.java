package problem3;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a = 0;
        int i = 0;
        int slen = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < slen; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                a = Math.max(a, j - i);
                int k = map.get(c);
                for (; i <= k; i++) {
                    map.remove(s.charAt(i));
                }
            }
            map.put(c, j);
        }
        return Math.max(a, slen - i);
    }
}
// @lc code=end

class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    void case1() {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void case2() {
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
    }
    
    @Test
    void case3() {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
    
    @Test
    void case4() {
        System.out.println(new Solution().lengthOfLongestSubstring(""));
    }
}
