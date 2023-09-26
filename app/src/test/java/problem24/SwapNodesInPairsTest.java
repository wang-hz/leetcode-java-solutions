package problem24;

import org.junit.jupiter.api.Test;

import infra.ListNode;

/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0, head);
        ListNode curr = ans;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            ListNode third = second.next;
            curr.next = second;
            second.next = first;
            first.next = third;
            curr = first;
        }
        return ans.next;
    }
}
// @lc code=end

class SwapNodesInPairsTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        ListNode.print(solution.swapPairs(ListNode.createFrom(new int[]{1,2,3,4})));
        ListNode.print(solution.swapPairs(null));
        ListNode.print(solution.swapPairs(ListNode.createFrom(new int[]{1})));
        ListNode.print(solution.swapPairs(ListNode.createFrom(new int[]{1,2,3})));
    }
}
