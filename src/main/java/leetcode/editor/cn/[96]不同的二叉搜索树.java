package leetcode.editor.cn;
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            if (n == 0) {
                return 0;
            }
            return genTreeNums(1, n);
        }

        private int genTreeNums(int start, int end) {
            int ans = 0;
            if (start >= end) {
                return 1;
            }
            for (int i = start; i <= end; i++) {
                // 得到所有可能的左子树
                int leftTreesNum = genTreeNums(start, i - 1);
                // 得到所有可能的右子树
                int rightTreesNum = genTreeNums(i + 1, end);
                // 左右子树的两两组合
                ans += leftTreesNum * rightTreesNum;
            }
            return ans;
        }

        public int numTrees4(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}