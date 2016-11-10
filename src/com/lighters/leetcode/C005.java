package com.lighters.leetcode;

/**
 * Created by david on 16/11/8.
 * <p>
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 *  这里的算法复杂度最快为 O(n)，最慢为 O(n^2)
 *
 *  可以使用 Manacher 算法对其进行优化，其复杂度为 O(n), 不过对空间有些消耗。
 */
public class C005 {
    public String longestPalindrome(String s) {
        int maxLeft = 0, maxRight = 0, left = 0, right = 0, len = s.length();
        for (int i = 0; i < len - (maxRight - maxLeft + 1) / 2; ) {
            right = left = i;
            while (right < len - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            i = right + 1;
            while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left > maxRight - maxLeft) {
                maxLeft = left;
                maxRight = right;
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    public static void main(String[] args) {
        System.out.println(new C005().longestPalindrome("abcca"));
        System.out.println(new C005().longestPalindrome("abccba"));
        System.out.println(new C005().longestPalindrome("ababab"));
        System.out.println(new C005().longestPalindrome("ababcbcb"));
        System.out.println(new C005().longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsgcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
    }
}
