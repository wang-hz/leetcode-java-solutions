package problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < nums.length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                for (int third = second + 1; third < nums.length - 1; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    int fourth = nums.length - 1;
                    while (third < fourth && (long) nums[first] + nums[second] + nums[third] + nums[fourth] > target) {
                        fourth--;
                    }
                    if (third == fourth) {
                        break;
                    }
                    if ((long) nums[first] + nums[second] + nums[third] + nums[fourth] == target) {
                        ans.add(List.of(nums[first], nums[second], nums[third], nums[fourth]));
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

class FourSumTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        System.out.println(solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(solution.fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}
