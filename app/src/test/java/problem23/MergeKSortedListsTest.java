package problem23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import infra.ListNode;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    void pushHeap(List<Integer> heap, int x) {
        int i = heap.size();
        heap.add(x);
        while (i > 0) {
            int j = (i - 1) / 2;
            if (heap.get(i) < heap.get(j)) {
                swap(heap, i, j);
                i = j;
            } else {
                break;
            }
        }
    }

    int popHeap(List<Integer> heap) {
        int x = heap.get(0);
        int n = heap.size() - 1;
        heap.set(0, heap.get(n));
        int p = 0;
        while (p <= n) {
            int l = 2 * p + 1;
            int r = l + 1;
            if (r <= n && heap.get(r) < heap.get(p) && heap.get(r) < heap.get(l)) {
                swap(heap, p, r);
                p = r;
            } else if (l <= n && heap.get(l) < heap.get(p)) {
                swap(heap, p, l);
                p = l;
            } else {
                break;
            }
        }
        heap.remove(n);
        return x;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> heap = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                pushHeap(heap, list.val);
                list = list.next;
            }
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        while (!heap.isEmpty()) {
            curr.next = new ListNode(popHeap(heap));
            curr = curr.next;
        }
        return head.next;
    }
}
// @lc code=end

class MergeKSortedListsTest {
    Solution solution = new Solution();

    @Test
    void case1() {
        List<Integer> heap = new ArrayList<>();
        solution.pushHeap(heap, 1);
        solution.pushHeap(heap, 4);
        solution.pushHeap(heap, 5);
        solution.pushHeap(heap, 1);
        solution.pushHeap(heap, 3);
        solution.pushHeap(heap, 4);
        solution.pushHeap(heap, 2);
        solution.pushHeap(heap, 6);
        assertEquals(1, solution.popHeap(heap));
        assertEquals(1, solution.popHeap(heap));
        assertEquals(2, solution.popHeap(heap));
        assertEquals(3, solution.popHeap(heap));
        assertEquals(4, solution.popHeap(heap));
        assertEquals(4, solution.popHeap(heap));
        assertEquals(5, solution.popHeap(heap));
        assertEquals(6, solution.popHeap(heap));
    }

    @Test
    void case2() {
        ListNode.print(solution.mergeKLists(new ListNode[]{}));
        ListNode.print(solution.mergeKLists(new ListNode[]{null}));
        ListNode.print(solution.mergeKLists(new ListNode[]{
            ListNode.createFrom(new int[]{1,4,5}),
            ListNode.createFrom(new int[]{1,3,4}),
            ListNode.createFrom(new int[]{2,6}),
        }));
        ListNode.print(solution.mergeKLists(new ListNode[]{
            ListNode.createFrom(new int[]{-1,1}),
            ListNode.createFrom(new int[]{-3,1,4}),
            ListNode.createFrom(new int[]{-2,-1,0,2}),
        }));
    }
}
