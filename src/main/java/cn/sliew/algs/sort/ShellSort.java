package cn.sliew.algs.sort;

public class ShellSort {

    public static void sort(int[] nums) {
        int h = 1;
        while (h < nums.length / 3){
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < nums.length; i++) {
                for (int j = i; j >= h && nums[j - h] > nums[j]; j -= h) {
                    int temp = nums[j - h];
                    nums[j - h] = nums[j];
                    nums[j] = temp;
                }
            }
            h = h / 3;
        }
    }
}
