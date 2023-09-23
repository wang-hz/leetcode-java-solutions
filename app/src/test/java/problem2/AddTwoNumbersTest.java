package problem2;

import org.junit.jupiter.api.Test;

import infra.ListNode;

/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p0 = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int sum = carry;
            if (p1 == null) {
                sum += p2.val;
                p2 = p2.next;
            } else if (p2 == null) {
                sum += p1.val;
                p1 = p1.next;
            } else {
                sum += p1.val + p2.val;
                p1 = p1.next;
                p2 = p2.next;
            }
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p0.next = new ListNode(sum);
            p0 = p0.next;
        }
        if (carry == 1) {
            p0.next = new ListNode(carry);
        }
        return res.next;
    }
}
// @lc code=end

class AddTwoNumbersTest {
    @Test
    void case1() {
        ListNode.print(new Solution().addTwoNumbers(ListNode.createFrom(new int[]{2,4,3}), ListNode.createFrom(new int[]{5,6,4})));
    }
}
