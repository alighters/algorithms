package com.lighters.leetcode;

/**
 * Created by david on 16/11/11.
 * <p>
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 * <p>
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * 参考链接：https://discuss.leetcode.com/topic/66987/java-solution
 */
public class C008 {

    public int myAtoi(final String a) {
        int x = 0;
        while (x < a.length() && a.charAt(x) == ' ') x++;

        String s = a.substring(x);
        if (s.length() == 0) return 0;

        char sign = s.charAt(0) == '-' ? '-' : '+';
        long num = 0l;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) continue;
            if (c < '0' || c > '9') break;
            num = num * 10 + c - '0';
            if (sign == '+' && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == '-' && num * -1 < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        if (sign == '-') num = -1 * num;
        return (int) num;
    }
}
