package com.lighters.leetcode;

/**
 * Created by david on 16/11/5.
 * <p>
 * <p>
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * <p>
 * 参考链接： https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/2
 */
public class C004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int imin = 0, i = 0, j = 0, maxLeft = 0, minRight, imax = m, halfLen = (m + n + 1) >> 1;

        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = halfLen - i;


            if (i < m && j > 0 && nums1[i] < nums2[j - 1]) {
                imin = i + 1;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = nums1[i - 1] > nums2[j - 1] ? nums1[i - 1] : nums2[j - 1];
                }
                break;
            }
        }

        if ((m + n) % 2 == 1) {
            return maxLeft;
        }
        if (i == m) {
            minRight = nums2[j];
        } else if (j == n) {
            minRight = nums1[i];
        } else {
            minRight = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
        }
        return (maxLeft + minRight) / 2.0;


    }

    public static void main(String[] args) {
        System.out.println(new C004().findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(new C004().findMedianSortedArrays(new int[]{}, new int[]{1,2,3}));
        System.out.println(new C004().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new C004().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(new C004().findMedianSortedArrays(new int[]{3}, new int[]{1, 2, 4}));
        System.out.println(new C004().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5, 6}));
        System.out.println(new C004().findMedianSortedArrays(new int[]{4}, new int[]{1, 2, 3, 5, 6}));
    }
}
