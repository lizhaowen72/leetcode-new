package leetcode.editor.cn;

//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {4, 7, 8, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int A[], int m, int B[], int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (A[i] > B[j]) {
                    A[k--] = A[i--];
                } else {
                    A[k--] = B[j--];
                }
            }
            while (j >= 0) {
                A[k--] = B[j--];
            }
        }

        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            // 将nums的数字全部移动到末尾
            for (int count = 1; count <= m; count++) {
                nums1[m + n - count] = nums1[m - count];
            }
            int i = n;
            int j = 0;
            int k = 0;
            // 遍历数组nums2
            while (j < n) {
                // 如果nums1遍历结束,将nums直接加入
                if (i == m + n) {
                    while (j < n) {
                        nums1[k++] = nums2[j++];
                    }
                    return;
                }
                // 那个数小就对应添加那个数
                if (nums2[j] < nums1[i]) {
                    nums1[k] = nums2[j++];
                } else {
                    nums1[k] = nums1[i++];
                }
                k++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}