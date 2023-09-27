package problem23;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import infra.ListNode;
import javafx.util.Pair;

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
    <T> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    void pushHeap(List<ListNode> heap, ListNode list) {
        int i = heap.size();
        heap.add(list);
        while (i > 0) {
            int j = (i - 1) / 2;
            if (heap.get(i).val < heap.get(j).val) {
                swap(heap, i, j);
                i = j;
            } else {
                break;
            }
        }
    }

    int popHeap(List<ListNode> heap) {
        ListNode top = heap.get(0);
        int n = heap.size() - 1;
        heap.set(0, heap.get(n));
        heap.remove(n);
        int i = 0;
        while (i < n) {
            int j = 2 * i + 1;
            int k = j + 1;
            if (k < n && heap.get(k).val < heap.get(j).val && heap.get(k).val < heap.get(i).val) {
                swap(heap, i, k);
                i = k;
            } else if (j < n && heap.get(j).val < heap.get(i).val) {
                swap(heap, i, j);
                i = j;
            } else {
                break;
            }
        }
        if (top.next != null) {
            pushHeap(heap, top.next);
        }
        return top.val;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> heap = new ArrayList<>();
        for (ListNode list : lists) {
            if (list != null) {
                pushHeap(heap, list);
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
