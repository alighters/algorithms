package com.lighters.leetcode;

/**
 * Created by david on 16/11/10.
 * <p>
 * Link: https://leetcode.com/problems/reverse-integer/
 * <p>
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * 注意：在反转的过程中，可能发生溢出的问题。这里，发生溢出的时候，需要返回 0 值。
 * 好的解决办法，用 long 来代替它们相加，之后判断是否超出整数的范围，来判断溢出。
 *
 * 我这里的解决办法是使用将其都转换为正数，使用位操作来判断两个数相加是否会发生溢出。
 */
public class C007 {

    public int reverse(int x) {
        int result = 0, m8, m2;
        boolean neg = false;
        if (x < 0) {
            x = -x;
            neg = true;
        }
        while (x != 0) {
            if ((result >>> 28) != 0) {
                return 0;
            }
            m8 = result << 3;
            m2 = result << 1;
            if (checkAddCarry(m8, m2)) {
                return 0;
            }
            result = (m2 + m8) + x % 10;
            x /= 10;
        }
        if (neg) {
            result = -result;
        }
        return result;
    }

    public boolean checkAddCarry(int a, int b) {
        int oneMask = a ^ b;
        int carryMask = a & b;
        int maskMoveCount = 30;
        while (maskMoveCount > 0) {
            if (((oneMask >> maskMoveCount) & 0x1) == 1 && ((carryMask >> maskMoveCount) & 0x1) == 0) {
                maskMoveCount--;
            } else if (((oneMask >> maskMoveCount) & 0x1) == 0 && ((carryMask >> maskMoveCount) & 0x1) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new C007().reverse(123));
        System.out.println(new C007().reverse(-123));
        System.out.println(new C007().reverse(-12));
        System.out.println(new C007().reverse(-1));
        System.out.println(new C007().reverse(-10));
        System.out.println(new C007().reverse(-0));
        System.out.println(new C007().reverse(1534236469));
        System.out.println(new C007().reverse(-2147483412));
        System.out.println(new C007().reverse(1563847412));
    }
}
