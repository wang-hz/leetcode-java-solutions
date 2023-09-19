package problem1;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(num, i);
        }
        return null;
    }
}
// @lc code=end

class TwoSumTest {
    @Test
    void case1() {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2,7,11,15}, 9)));
    }
}
