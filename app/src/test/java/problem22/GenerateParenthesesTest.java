package problem22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        int len = 2 * n;
        List<Pair<StringBuilder, Integer>> pairs = List.of(new Pair<StringBuilder, Integer>(new StringBuilder("("), 1));
        for (int i = 1; i < len; i++) {
            List<Pair<StringBuilder, Integer>> newPairs = new ArrayList<>();
            for (Pair<StringBuilder, Integer> pair : pairs) {
                int leftCount = pair.getValue();
                if (leftCount > 0) {
                    StringBuilder right = new StringBuilder(pair.getKey());
                    right.append(')');
                    newPairs.add(new Pair<StringBuilder, Integer>(right, leftCount - 1));
                }
                if (len - i - leftCount > 0) {
                    StringBuilder left = new StringBuilder(pair.getKey());
                    left.append('(');
                    newPairs.add(new Pair<StringBuilder, Integer>(left, leftCount + 1));
                }
            }
            pairs = newPairs;
        }
        return pairs.stream().map(pair -> pair.getKey().toString()).collect(Collectors.toList()); 
    }
}
// @lc code=end

class GenerateParenthesesTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        System.out.println(solution.generateParenthesis(3).toString());
        System.out.println(solution.generateParenthesis(1).toString());
    }
}
