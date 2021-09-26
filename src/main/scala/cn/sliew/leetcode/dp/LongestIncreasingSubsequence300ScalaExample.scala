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




        maxLength
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(10, 9, 2, 5, 3, 7, 101, 18)
        val result = lengthOfLIS(nums)
        println(result)
    }
}
