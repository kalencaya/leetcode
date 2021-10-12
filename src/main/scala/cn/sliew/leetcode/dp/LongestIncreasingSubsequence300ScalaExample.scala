package cn.sliew.leetcode.dp

/**
  * 300. Longest Increasing Subsequence mediym
  */
object LongestIncreasingSubsequence300ScalaExample {

    def lengthOfLIS(nums: Array[Int]): Int = {
        if (nums.length == 1) {
            return 1
        }
        var maxLength = 0

        val dp = new Array[Int](nums.length + 1)

        for (i <- 1 to nums.length) {
            val current = nums(i - 1)
//            dp(i) =
        }




        maxLength
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(10, 9, 2, 5, 3, 7, 101, 18)
        val result = lengthOfLIS(nums)
        println(result)
    }
}
