package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] candidates = {2, 3, 6, 7};
        solution.combinationSum(candidates, 7);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            combinationSum(candidates, res, new ArrayList<Integer>(), target, 0);
            return res;
        }

        private void combinationSum(int[] candidates, List<List<Integer>> res, ArrayList<Integer> tempList, int sum, int start) {
            if (sum < 0) {
                return;
            } else if (sum == 0) {
                res.add(new ArrayList<>(tempList));
            } else {
                for (int i = start; i < candidates.length; i++) {
                    tempList.add(candidates[i]);
                    combinationSum(candidates, res, tempList, sum - candidates[i], i);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}