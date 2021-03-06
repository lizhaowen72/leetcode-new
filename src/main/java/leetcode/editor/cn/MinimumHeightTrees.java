package leetcode.editor.cn;
//对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
//
// 格式 
//
// 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。 
//
// 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。 
//
// 示例 1: 
//
// 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//        0
//        |
//        1
//       / \
//      2   3 
//
//输出: [1]
// 
//
// 示例 2: 
//
// 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
//
//     0  1  2
//      \ | /
//        3
//        |
//        4
//        |
//        5 
//
//输出: [3, 4] 
//
// 说明: 
//
// 
// 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
// 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。 
// 
// Related Topics 广度优先搜索 图


import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTrees().new Solution();
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        solution.findMinHeightTrees(4, edges);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();
            // 特殊情况
            if (n <= 2) {
                for (int i = 0; i < n; i++) {
                    res.add(i);
                }
                return res;
            }
            Set<Integer>[] graph = new Set[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new HashSet<>();
            }
            int[] indegrees = new int[n];
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
                indegrees[edge[0]]++;
                indegrees[edge[1]]++;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (indegrees[i] == 1) {
                    queue.addLast(i);
                }
            }
            while (n > 2) {
                int size = queue.size();
                n -= size;
                while (size-- > 0) {
                    Integer curr = queue.poll();
                    indegrees[curr]--;
                    if (!graph[curr].isEmpty()) {
                        for (Integer node : graph[curr]) {
                            indegrees[node]--;
                            if (indegrees[node] == 1) {
                                queue.add(node);
                            }
                            graph[curr].remove(node);
                            graph[node].remove(curr);
                        }
                    }
                }
            }
            return queue;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}