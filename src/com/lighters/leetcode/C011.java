package com.lighters.leetcode;

/**
 * Created by david on 16/12/31.
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class C011 {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int area, maxArea = 0;
        while (low < high) {
            if (height[high] < height[low]) {
                area = height[high] * (high - low);
                high--;
            } else {
                area = height[low] * (high - low);
                low++;
            }

            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        System.out.println(new C011().maxArea(new int[]{1, 2, 4, 3}));
    }


}
