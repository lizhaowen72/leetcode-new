package leetcode.editor.cn;
//给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。 
//
// 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。 
//
// 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。 
//
// 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。 
//
// 示例 1: 
//
// 
//输入: 
//二叉树如下所示:
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
//
//v = 1
//
//d = 2
//
//输出: 
//       4
//      / \
//     1   1
//    /     \
//   2       6
//  / \     / 
// 3   1   5   
//
// 
//
// 示例 2: 
//
// 
//输入: 
//二叉树如下所示:
//      4
//     /   
//    2    
//   / \   
//  3   1    
//
//v = 1
//
//d = 3
//
//输出: 
//      4
//     /   
//    2
//   / \    
//  1   1
// /     \  
//3       1
// 
//
// 注意: 
//
// 
// 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。 
// 输入的二叉树至少有一个节点。 
// 
// Related Topics 树

import sun.reflect.generics.tree.Tree;

public class AddOneRowToTree {
    public static void main(String[] args) {
        Solution solution = new AddOneRowToTree().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * The idea is to:
         * In addition to use 1 to indicate attach to left node as required, we can also use 0 to indicate attach to right node;
         * @param root
         * @param v
         * @param d
         * @return
         */
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 0 || d == 1) {
                TreeNode newRoot = new TreeNode(v);
                newRoot.left = d == 1 ? root : null;
                newRoot.right = d == 0 ? root : null;
                return newRoot;
            }
            if (root != null && d >= 2) {
                root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
                root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
            }
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}