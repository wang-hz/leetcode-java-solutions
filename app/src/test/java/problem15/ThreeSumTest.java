package problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                }
            }
        }
        return res;
    }
}
// @lc code=end

class ThreeSumTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}).toString());
        System.out.println(solution.threeSum(new int[]{0,1,1}).toString());
        System.out.println(solution.threeSum(new int[]{0,0,0}).toString());
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}).toString());
    }
}
