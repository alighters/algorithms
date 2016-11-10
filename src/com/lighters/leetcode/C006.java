package com.lighters.leetcode;

/**
 * Created by david on 16/11/10.
 *
 * Link: https://leetcode.com/problems/zigzag-conversion/
 *
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * 解法：找出排列的规律，按规则分行读取即可。
 *
 */
public class C006 {

    public String convert(String s, int numRows) {
        int len = s.length();
        char[] result = new char[len];
        int index = 0, addFlag;
        for (int row = 0; row < numRows; row++) {
            if (row == 0 || row == numRows - 1)
                for (int i = row; i < len; ) {
                    result[index++] = s.charAt(i);
                    i += 2 * numRows - 2 > 0 ? 2 * numRows -2 : 1;
                }
            else {
                addFlag = 0;
                for (int i = row; i < len; ) {
                    result[index++] = s.charAt(i);
                    if (addFlag % 2 == 0) {
                        i += 2 * (numRows - row - 1);
                    } else {
                        i += 2 * row;
                    }
                    addFlag++;
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new C006().convert("PAYPALISHIRING", 4));
        System.out.println(new C006().convert("A", 1));
    }
}
