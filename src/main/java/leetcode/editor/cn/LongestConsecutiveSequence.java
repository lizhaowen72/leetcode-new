package leetcode.editor.cn;
//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组
public class LongestConsecutiveSequence{
    public static void main(String[] args) {
         Solution solution = new LongestConsecutiveSequence().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
           this.val = x;
        }
    }
}