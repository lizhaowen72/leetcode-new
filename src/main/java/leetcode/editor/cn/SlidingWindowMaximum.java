package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[0];
            }

            int[] maxes = new int[nums.length - k + 1];

            int i, j;
            int maxPos = -1;

            for (i = 0; i <= nums.length - k; ++i) {
                // Ending index of the current window
                j = i + k - 1;

                // new element >= max of last window
                // that means new element is max in the two windows
                // here using >= to make maxPos stay in the windows for a longer time
                if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                    maxPos = j;
                    maxes[i] = nums[maxPos];
                }
                // new element < max of last window
                // AND the max of last window is also in this window
                // => it means the max of the last window is still the max of this window
                else if (i <= maxPos) {
                    maxes[i] = nums[maxPos];
                }
                // new element < max of last window
                // AND the max of last window is not in this window
                // So we do not know which element is the max in this window, we have to scan the window to find it
                else {
                    int maxWindow = Integer.MIN_VALUE;
                    int maxPosWindow = 0;
                    for (int z = i; z <= j; ++z) {
                        if (nums[z] > maxWindow) {
                            maxPosWindow = z;
                            maxWindow = nums[z];
                        }
                    }
                    maxPos = maxPosWindow;
                    maxes[i] = nums[maxPos];
                }
            }
            return maxes;
        }
        public int[] maxSlidingWindow3(int[] nums, int k) {
            if (nums == null || k <= 0) {
                return new int[0];
            }
            int len = nums.length;
            int[] res = new int[len - k + 1];
            int ri = 0;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                // remove numbers out of range k
                while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                    deque.poll();
                }
                // remove smaller number in k range as they are useless
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                // deque contains index... res contains content
                deque.offer(i);
                if (i >= k - 1) {
                    res[ri++] = nums[deque.peek()];
                }
            }
            return res;
        }

        public int[] maxSlidingWindow2(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) {
                return new int[0];
            }
            int[] output = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    max = Math.max(max, nums[j]);
                }
                output[i] = max;
            }
            return output;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}