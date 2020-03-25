package leetcode.editor.cn;
//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划

class DecodeWays{
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        solution.numDecodings("122");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * I used a dp array of size n + 1 to save subproblem solutions.
         * dp[0] means an empty string will have one way to decode,
         * dp[1] means the way to decode a string of size 1.
         * I then check one digit and two digit combination and save the results along the way.
         * In the end, dp[n] will be the end result.
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;
            for (int i = 2; i <= n; i++) {
                int first = Integer.valueOf(s.substring(i - 1, i));
                int second = Integer.valueOf(s.substring(i - 2, i));
                if (first >= 1 && first <= 9) {
                    dp[i] += dp[i - 1];
                }
                if (second >= 10 && second <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}