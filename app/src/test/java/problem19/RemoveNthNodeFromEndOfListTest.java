package problem19;

import org.junit.jupiter.api.Test;

import infra.ListNode;

/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        ListNode second = head;
        for (; first.next != null; first = first.next) {
            second = second.next;
        }
        second.next = second.next.next;
        return head.next;
    }
}
// @lc code=end

class RemoveNthNodeFromEndOfListTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        ListNode.print(solution.removeNthFromEnd(new ListNode(new int[]{1,2,3,4,5}), 2));;
        ListNode.print(solution.removeNthFromEnd(new ListNode(new int[]{1}), 1));;
        ListNode.print(solution.removeNthFromEnd(new ListNode(new int[]{1,2}), 1));;
    }
}
