package com.lighters.common.sort;

/**
 * Created by david on 16/11/1.
 */
public class QuickSort {

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int k = partition(nums, low, high);
            quickSort(nums, low, k - 1);
            quickSort(nums, k + 1, high);

        }
    }

    private int partition(int[] nums, int i, int j) {
        int base = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= base) {
                j--;
            }
            while (i < j && nums[i] < base) {
                i++;
            }


            if (i < j) {
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int a[] = {2, 1, -4, 5, 3};
        new QuickSort().quickSort(a, 0, 4);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
