package leetcode.editor.cn;
//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计

import java.util.PriorityQueue;
import java.util.Queue;

class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder solution = new FindMedianFromDataStream().new MedianFinder();
        solution.addNum(41);
        solution.addNum(35);
        solution.addNum(62);
        solution.addNum(5);
        solution.addNum(97);
        solution.addNum(108);
        System.out.println(solution.findMedian());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private Queue<Long> samll, large;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            samll = new PriorityQueue<>();
            large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            large.add((long) num);
            samll.add(-large.poll());
            if (large.size() < samll.size()) {
                large.add(-samll.poll());
            }
        }

        public double findMedian() {
            return large.size() > samll.size() ? large.peek() : (large.peek() - samll.peek()) * 0.5;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}