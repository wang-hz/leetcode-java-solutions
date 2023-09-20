package problem14;

/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            Character ch = null;
            for (String str : strs) {
                if (i >= str.length()) {
                    return sb.toString();
                } else if (ch == null) {
                    ch = str.charAt(i);
                } else if (!Character.valueOf(str.charAt(i)).equals(ch)) {
                    return sb.toString();
                }
            }
            sb.append(ch);
            i++;
        }
    }
}
// @lc code=end

