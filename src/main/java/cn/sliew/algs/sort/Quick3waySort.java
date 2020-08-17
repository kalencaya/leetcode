package cn.sliew.algs.sort;

public class Quick3waySort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int left = lo;
        int right = hi;
        int num = nums[lo];
        int i = lo + 1;
        while (i <= right) {
            int cmp = nums[i] - num;
            if (cmp > 0) {
                swap(nums, i, right--);
            } else if (cmp < 0) {
                swap(nums, left++, i++);
            } else {
                i++;
            }
        }
        sort(nums, lo, left - 1);
        sort(nums, right + 1, hi);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
