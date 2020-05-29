package leetcode.editor.cn;
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法

class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        //solution.isMatch("aa","a");
        solution.isMatch3("aa", "a*");
        solution.isMatch("ab", ".*");
        solution.isMatch("aab", "c*a*b");
        solution.isMatch("mississippi", "mis*is*p*.");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch5(String text, String pattern) {
            boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
            dp[text.length()][pattern.length()] = true;
            for (int i = text.length(); i >= 0; i--) {
                for (int j = pattern.length(); j >= 0; j--) {
                    if (i == text.length() && j == pattern.length()) continue;
                    boolean first_match = (i < text.length() && j < pattern.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                    } else {
                        dp[i][j] = first_match && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }

        // '.' 匹配任意单个字符
        //'*' 匹配零个或多个前面的那一个元素
        public boolean isMatch3(String text, String pattern) {
            if (pattern.isEmpty()) { // 如果pattern为空,就看text是否为空
                return text.isEmpty();
            }
            // 如果pattern不为空,则尝试匹配text和pattern的第一个字符,考虑两种情况,第一text.charAt(0) == pattern.charAt(0),第二pattern.charAt(0) == '.'
            boolean first_match = (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));
            // 如果pattern的长度大于等于2,并且pattern的第二个字符为*(该'*'可以匹配0个或者多个前面的字符)
            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                // 也分为两种情况
                // 第一firstMatch为false,则直接跳过pattern的前两个字符,比如pattern = "a*",这个时候*的作用是将前面的字符匹配0个
                // 第二种firstMatch为true,text从第二个字符开始,这里传pattern进去,是要知道pattern中的字符'*'前面的字符
                return (isMatch3(text, pattern.substring(2)) || (first_match && isMatch3(text.substring(1), pattern)));
            } else {
                // 否则直接匹配之
                return first_match && isMatch3(text.substring(1), pattern.substring(1));
            }

        }

        public boolean isMatch2(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                        }
                    }
                }
            }
            System.out.println(dp[s.length()][p.length()]);
            return dp[s.length()][p.length()];
        }

        public boolean isMatch(String text,String pattern){
            if (pattern.isEmpty()){
                return text.isEmpty();
            }
            boolean firstMatch = (!text.isEmpty())&&(text.charAt(0)==pattern.charAt(0)||pattern.charAt(0)=='.');
            if (pattern.length()>=2&&pattern.charAt(1)=='*'){
                return isMatch(text,pattern.substring(2))||firstMatch&&(isMatch(text.substring(1),pattern));
            }else{
                return firstMatch&&isMatch(text.substring(1),pattern.substring(1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}