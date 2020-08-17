package cn.sliew.algs.sort;

public class MergeSort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        int[] copy = new int[nums.length];
        for (int i = lo; i <= hi; i++) {
            copy[i] = nums[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; i <= hi; k++) {
            if (i > mid) {
                nums[k] = copy[j++];
            } else if (j > hi) {
                nums[k] = copy[i++];
            } else if (nums[i] < nums[j]) {
                nums[k] = nums[i++];
            } else {
                nums[k] = nums[j++];
            }
        }
    }
}
