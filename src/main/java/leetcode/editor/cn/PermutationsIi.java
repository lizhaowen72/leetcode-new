package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {1, 1, 2};
        solution.permuteUnique(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
            return res;
        }

        private void backTrack(List<List<Integer>> res, List<Integer> tempLis, int[] nums, boolean[] used) {
            if (tempLis.size() == nums.length) {
                res.add(new ArrayList<>(tempLis));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tempLis.add(nums[i]);
                backTrack(res, tempLis, nums, used);
                used[i] = false;
                tempLis.remove(tempLis.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}