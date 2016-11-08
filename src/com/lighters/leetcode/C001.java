package com.lighters.leetcode;

import com.lighters.common.sort.QuickSort;

import java.util.HashMap;

/**
 * Created by david on 16/11/1.
 * <p>
 * <p>
 * <p>
 * Question: Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 思路：初始想法为将其排序之后，利用两个指针移动来解决，但又需要考虑原始坐标的问题。（我这里利用了一个新的数组来解决，但在快排的时候，
 * 发生了 StackOverflow 的问题。）所以最后参见讨论中，有人给出的，利用 HashMap 的结构来解决，空间换时间，---> 好的数据结构很重要啊。
 */
public class C001 {

    /**
     * 题目中可知结果唯一，即不存在重复的数字，即可利用快速排序，同时新建一个数组用来维持 （算法不通过，当数组长度过长，会因排序出现 StackOverflow 的异常。）
     *
     * @param nums
     * @param target
     * @return
     */

//    public int[] twoSum(int[] nums, int target) {
//        int[] orders = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            orders[i] = i;
//        }
//
//
//        int i = 0;
//        int j = nums.length - 1;
//        quickSort(nums, orders, i, j);
//        while (i < j) {
//            if (nums[orders[i]] + nums[orders[j]] > target) {
//                j--;
//            } else if (nums[orders[i]] + nums[orders[j]] < target) {
//                i++;
//            } else {
//                int[] result = {orders[i], orders[j]};
//                return result;
//            }
//        }
//        return null;
//    }
//
//    public void quickSort(int[] nums, int[] orders, int low, int high) {
//        if (low < high) {
//            int k = partition(nums, orders, low, high);
//            quickSort(nums, orders, low, k - 1);
//            quickSort(nums, orders, k + 1, high);
//
//        }
//    }
//
//    private int partition(int[] nums, int[] orders, int i, int j) {
//        int base = nums[orders[i]];
//        while (i < j) {
//            while (i < j && nums[orders[j]] >= base) {
//                j--;
//            }
//            while (i < j && nums[orders[i]] < base) {
//                i++;
//            }
//
//
//            if (i < j) {
//                orders[i] = orders[i] ^ orders[j];
//                orders[j] = orders[i] ^ orders[j];
//                orders[i] = orders[i] ^ orders[j];
//            }
//        }
//        return i;
//    }
//
//
//    public static void main(String[] args) {
//        int[] test = {
//                0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38};
//        int[] result = new C001().twoSum(test, 34);
//        for (int i = 0; i < result.length;
//             i++) {
//            System.out.print(result[i] + " ");
//        }
//
//    }

    /**
     * 利用 HashMap 的数据结构来求解 （通过）
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(target - nums[i])) return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return null;
    }

}
