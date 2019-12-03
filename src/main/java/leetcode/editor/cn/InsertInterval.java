package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组
public class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<Interval> res = new ArrayList<>();
            for (int[] interval : intervals) {
                res.add(new Interval(interval[0],interval[1]));
            }
            List<Interval> insert = insert(res, new Interval(newInterval[0], newInterval[1]));
            int[][] result = new int[insert.size()][insert.size()];
            for (Interval interval : insert) {

            }
        }

        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> result = new LinkedList<>();
            int i = 0;
            // add all the intervals ending before newInterval starts
            while (i < intervals.size() && intervals.get(i).end < newInterval.start)
                result.add(intervals.get(i++));
            // merge all overlapping intervals to one considering newInterval
            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval = new Interval( // we could mutate newInterval here also
                        Math.min(newInterval.start, intervals.get(i).start),
                        Math.max(newInterval.end, intervals.get(i).end));
                i++;
            }
            result.add(newInterval); // add the union of intervals we got
            // add all the rest
            while (i < intervals.size()) result.add(intervals.get(i++));
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Interval {
        int start;
        int end;

        public Interval(int start, int end,) {
            this.end = end;
            this.start = start;
        }
    }
}