package problem17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        int digitsLastIndex = digits.length() - 1;
        if (digitsLastIndex < 0) {
            return List.of();
        }
        Map<Character, List<Character>> map = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
        );
        List<StringBuilder> sbList = new ArrayList<>(){{ add(new StringBuilder()); }};
        for (int i = 0; i <= digitsLastIndex; i++) {
            char digit = digits.charAt(i);
            List<StringBuilder> newSbList = new ArrayList<>();
            for (StringBuilder sb : sbList) {
                for (char alpha : map.get(digit)) {
                    StringBuilder newSb = new StringBuilder(sb);
                    newSb.append(alpha);
                    newSbList.add(newSb);
                }
            }
            sbList = newSbList;
        }
        return sbList.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
}
// @lc code=end

class LetterCombinationsOfAPhoneNumberTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("2"));
    }
}
