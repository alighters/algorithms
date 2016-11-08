package com.lighters.leetcode;

/**
 * Created by david on 16/11/3.
 * <p>
 *     Link:
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * 思路：通过两个指针记录之前最大的不重复子串，遇到的一个新的字符时，与最大子串中的字符进行判断，判断是否存在相同的字符，若存在则更新新的最大子串。
 *      若不存在，则对最大子串进行加一。另外，通过一个变量来保存子串的长度。
 *
 * 优化空间：最终的结果是击败了 77.01% , 主要时间是花在子串的遍历是否存在相同的问题上，这里可以考虑通过空间换时间优化。
 */
public class C003 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = s.length() > 0 ? 1 : 0;
        for (int i = 1, m = 0, n = 0; i < s.length(); i++) {

            for (int k = m; k <= n; k++) {
                if (s.charAt(k) == s.charAt(i)) {
                    m = k + 1;
                    break;
                }
            }

            n = i;

            if (n - m + 1 > maxLength) {
                maxLength = n - m + 1;
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(new C003().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new C003().lengthOfLongestSubstring("c"));
        System.out.println(new C003().lengthOfLongestSubstring(""));
    }
}
