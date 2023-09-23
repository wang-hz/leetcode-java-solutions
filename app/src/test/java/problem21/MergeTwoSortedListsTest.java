package problem21;

import org.junit.jupiter.api.Test;

import infra.ListNode;

/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = new ListNode();
        ListNode ans = ptr1;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr1.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                ptr1.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            ptr1 = ptr1.next;
        }
        ListNode ptr2 = list1 == null ? list2 : list1;
        while (ptr2 != null) {
            ptr1.next = new ListNode(ptr2.val);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ans.next;
    }
}
// @lc code=end

class MergeTwoSortedListsTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        ListNode.print(solution.mergeTwoLists(ListNode.createFrom(new int[]{1,2,4}), ListNode.createFrom(new int[]{1,3,4})));
        ListNode.print(solution.mergeTwoLists(ListNode.createFrom(new int[]{}), ListNode.createFrom(new int[]{})));
        ListNode.print(solution.mergeTwoLists(ListNode.createFrom(new int[]{}), ListNode.createFrom(new int[]{0})));
    }
}
