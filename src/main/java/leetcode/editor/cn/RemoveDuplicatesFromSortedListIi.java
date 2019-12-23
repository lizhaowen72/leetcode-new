package leetcode.editor.cn;

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
//        ListNode node2 = new ListNode(2);
//        ListNode node22 = new ListNode(2);
//        ListNode node222 = new ListNode(2);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(4);
//        ListNode node44 = new ListNode(4);
//        node2.next = node22;
//        node22.next = node222;
//        node222.next = node5;
//        node5.next = node6;
//        node6.next = node44;
//        solution.deleteDuplicates(node2);
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode pre = dummyNode;
            ListNode cur = head;
            while (cur != null) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if (pre.next == cur) {
                    pre = pre.next;
                } else {
                    pre.next = cur.next;
                }
                cur = cur.next;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}