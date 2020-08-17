package cn.sliew.algs.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[index]) {
                    index = j;
                }
            }

            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 5, 8};
        sort(nums);
        show(nums);
    }
}
