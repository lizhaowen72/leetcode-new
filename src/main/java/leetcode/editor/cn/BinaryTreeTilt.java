package leetcode.editor.cn;
//给定一个二叉树，计算整个树的坡度。
//
// 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。 
//
// 整个树的坡度就是其所有节点的坡度之和。 
//
// 示例: 
//
// 
//输入: 
//         1
//       /   \
//      2     3
//输出: 1
//解释: 
//结点的坡度 2 : 0
//结点的坡度 3 : 0
//结点的坡度 1 : |2-3| = 1
//树的坡度 : 0 + 0 + 1 = 1
// 
//
// 注意: 
//
// 
// 任何子树的结点的和不会超过32位整数的范围。 
// 坡度的值不会超过32位整数的范围。 
// 
// Related Topics 树


public class BinaryTreeTilt {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeTilt().new Solution();
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
        int result = 0;

        public int findTilt(TreeNode root) {
            postOrder(root);
            return result;
        }

        private int postOrder(TreeNode root) {
            if (root == null) return 0;
            int left = postOrder(root.left);
            int right = postOrder(root.right);
            result += Math.abs(left - right);
            return root.val + left + right;
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