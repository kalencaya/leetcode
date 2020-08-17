package cn.sliew.algs.sort;

public class QuickSort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    /**
     * 选择第一个元素作为切分点
     */
    private static int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int num = nums[lo];
        while (true) {
            while (nums[++i] < num) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > num) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[lo] = nums[j];
        nums[j] = num;
        return j;
    }
}
