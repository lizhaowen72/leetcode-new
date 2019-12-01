package leetcode.editor.cn;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node1e = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4e = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        node1.next = node4;
        node4.next = node5;
        node1e.next = node3;
        node3.next = node4e;
        node2.next = node6;
        ListNode[] lists = {node1, node1e, node2};
        solution.mergeKLists(lists);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<ListNode> listNodes = Arrays.asList(lists);
            if (listNodes == null || listNodes.size() == 0) {
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(listNodes.size(), new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val < o2.val) {
                        return -1;
                    } else if (o1.val == o2.val) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            for (ListNode listNode : listNodes) {
                if (listNode != null) {
                    queue.add(listNode);
                }
            }
            while (!queue.isEmpty()) {
                tail.next = queue.poll();
                tail = tail.next;
                if (tail.next != null) {
                    queue.add(tail.next);
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}