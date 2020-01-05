package leetcode.editor.cn;
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的深拷贝。 
//
// 
//
// 示例： 
//
// 
//
// 输入：
//{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"rando
//m":{"$ref":"2"},"val":1}
//
//解释：
//节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
//节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
// 
//
// 
//
// 提示： 
//
// 
// 你必须返回给定头的拷贝作为对克隆列表的引用。 
// 
// Related Topics 哈希表 链表

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    class Solution {
        Map<Node, Node> visited = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            if (visited.containsKey(head)) {
                return visited.get(head);
            }
            Node node = new Node(head.val);
            visited.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}