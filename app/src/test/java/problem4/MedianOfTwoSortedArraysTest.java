package problem4;

import org.junit.jupiter.api.Test;

/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len_sum = len1 + len2;
        int l = 0;
        int r = len1;
        int m1 = 0;
        int m2 = 0;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = (len_sum + 1) / 2 - i;
            int nums1_im1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1_i = i == len1 ? Integer.MAX_VALUE : nums1[i];
            int nums2_jm1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2_j = j == len2 ? Integer.MAX_VALUE : nums2[j];
            if (nums1_im1 <= nums2_j) {
                m1 = Math.max(nums1_im1, nums2_jm1);
                m2 = Math.min(nums1_i, nums2_j);
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        return len_sum % 2 == 1 ? m1 : (m1 + m2) / 2.0;
    }
}
// @lc code=end

class MedianOfTwoSortedArraysTest {
    @Test
    void case1() {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    @Test
    void case2() {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
