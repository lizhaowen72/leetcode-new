package leetcode.editor.cn;

//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针
public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution.rotateRight(node1, 2);

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
        public ListNode rotateRight(ListNode head, int k) {
            // base cases
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            // close the linked list into the ring
            ListNode old_tail = head;
            int n;
            for (n = 1; old_tail.next != null; n++) {
                old_tail = old_tail.next;
            }
            old_tail.next = head;
            // find new tail : (n - k % n - 1)th node
            // and new head : (n - k % n)th node
            ListNode new_tail = head;
            for (int i = 0; i < n - k % n - 1; i++) {
                new_tail = new_tail.next;
            }
            ListNode new_head = new_tail.next;
            // break the ring
            new_tail.next = null;
            return new_head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}