package com.lighters.leetcode;

/**
 * Created by david on 16/11/11.
 * <p>
 * Link: https://leetcode.com/problems/palindrome-number/
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * click to show spoilers.
 * <p>
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 */
public class C009 {
    public boolean isPalindrome(int x) {
        long y = 0, z = x;
        while (x > 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (y < Integer.MAX_VALUE && y > Integer.MIN_VALUE) {
            if (z == y)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new C009().isPalindrome(101));
//        System.out.println(new C009().isPalindrome(-101));
        System.out.println(new C009().isPalindrome(-2147447412));
        System.out.println(new C009().isPalindrome(0));
    }

//
//    public boolean isPalindrome(int x) {
//        if(x<0) return false;
//        int d = 1;
//        while(x/d>=10) d*=10;
//        while(x>0){
//            if(x%10 != x/d) return false;
//            x = (x-(x/d)*d)/10;
//            d/=100;
//        }
//        return true;
//    }

}
