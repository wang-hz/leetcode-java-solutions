package problem16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = nums.length - 1;
                while (j < k && nums[i] + nums[j] + nums[k] > target) {
                    k--;
                }
                if (k + 1 < nums.length) {
                    int sum = nums[i] + nums[j] + nums[k + 1];
                    int diff = Math.abs(sum - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans = sum;
                    }
                }
                if (j == k) {
                    break;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else {
                    int diff = Math.abs(sum - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

class ThreeSumClosestTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        assertEquals(2, solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        assertEquals(0, solution.threeSumClosest(new int[]{0,0,0}, 1));
    }
}
