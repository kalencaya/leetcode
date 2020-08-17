package cn.sliew.algs.sort;

public class SortExample {

    public static void sort(int[] nums) {
        Quick3waySort.sort(nums);
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
        int[] nums = new int[]{3, 1, 2, 7, 7, 5, 8, 4, 2, 4, 9, 6};
        sort(nums);
        show(nums);
    }
}
