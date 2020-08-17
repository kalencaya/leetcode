package cn.sliew.leetcode.array

/**
  * 674.Longest Continuous Increasing Subsequence easy
  */
object LongestContinuousIncreasingSubsequence674ScalaExample {
    def findLengthOfLCIS(nums: Array[Int]): Int = {
        if (nums == null || nums.length == 0) {
            return 0
        }
        if (nums.length == 1) {
            return 0
        }

        var max = 0
        var temp = 1
        for (i <- 0 until nums.length) {
            if (i > 0 && nums(i) > nums(i - 1)) {
                temp += 1
            } else {
                max = math.max(max, temp)
                temp = 1
            }
        }
        math.max(max, temp)
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 3, 5, 7)
        val result = findLengthOfLCIS(nums)
        print(result)
    }

}
