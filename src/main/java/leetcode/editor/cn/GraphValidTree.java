package leetcode.editor.cn;

import java.util.Arrays;

//给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
//
// 示例 1： 
//
// 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
//输出: true 
//
// 示例 2: 
//
// 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//输出: false 
//
// 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，因此不会同时出现在边列表 edges 中。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图
public class GraphValidTree {
    public static void main(String[] args) {
        Solution solution = new GraphValidTree().new Solution();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        solution.validTree(5, edges2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            DisjointSet disjointSet = new DisjointSet(n);
            for (int[] edge : edges) {
                if (!disjointSet.union(edge[0], edge[1])) {
                    return false;
                }
            }
            return disjointSet.getCount() == 1;
        }

        class DisjointSet {
            int n;
            int[] parent;// 父亲
            int[] rank; // 树的高度
            int count; // 连同分量

            // 初始化n个元素
            public DisjointSet(int n) {
                this.n = n;
                this.parent = new int[n];
                Arrays.fill(parent, -1);
                this.rank = new int[n];
                this.count = n;
            }

            /**
             * 查询树的根
             *
             * @param x
             * @return
             */
            private int findRoot(int x) {
                int root = x;
                while (parent[root] != -1) {
                    root = parent[root];
                }
                return root;
            }

            /**
             * 合并x和y所属的集合
             *
             * @param x
             * @param y
             * @return
             */
            public boolean union(int x, int y) {
                int xRoot = findRoot(x);
                int yRoot = findRoot(y);
                if (xRoot == yRoot) {
                    return false;
                }
                if (rank[xRoot] > rank[yRoot]) {
                    // yRoot所在的根是xRoot
                    parent[yRoot] = xRoot;
                } else if (rank[xRoot] < rank[yRoot]) {
                    parent[xRoot] = yRoot;
                } else if (rank[xRoot] == rank[yRoot]) {
                    parent[xRoot] = yRoot;
                    rank[yRoot]++;
                }
                count--;
                return true;
            }

            public int getCount() {
                return this.count;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}