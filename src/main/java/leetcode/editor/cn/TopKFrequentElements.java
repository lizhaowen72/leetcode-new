package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 说明： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 
// Related Topics 堆 哈希表
public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        int[] nums = {2, 2, 1, 1, 1, 3, 3, 3, 4, 4, 4, 1, 4,5,5,5,5};
        solution.topKFrequent(nums, 2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // Idea is simple. Build a array of list to be buckets with length 1 to sort.
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer>[] bucket = new List[nums.length];
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Integer key : map.keySet()) {
                int value = map.get(key);
                if (bucket[value] == null) {
                    bucket[value] = new ArrayList<>();
                }
                bucket[value].add(key);
            }
            List<Integer> res = new ArrayList<>();
            for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
                if (bucket[pos] != null) {
                    res.addAll(bucket[pos]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}