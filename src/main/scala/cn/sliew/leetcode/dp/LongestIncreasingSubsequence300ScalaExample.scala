package cn.sliew.leetcode.dp

/**
  * 300. Longest Increasing Subsequence mediym
  */
object LongestIncreasingSubsequence300ScalaExample {

    def lengthOfLIS(nums: Array[Int]): Int = {
        if (nums.length == 1) {
            return 1
        }

        val dp = new Array[Int](nums.length)
        dfs(dp, nums(0), 1, nums)
    }

    private def dfs(dp: Array[Int], num: Int, start: Int, nums: Array[Int]): Int = {
        if (start == nums.length) {
            return 0
        }

        if (dp(start) != 0) {
            return dp(start)
        }
        var maxLength = 0
        for (i <- start until nums.length; if nums(i) > num) {
            val length = 1 + dfs(dp, dp(start), i + 1, nums)
            maxLength = math.max(length, maxLength)
        }
        dp(start) = maxLength
        maxLength
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(10,9,2,5,3,7,101,18)
        val result = lengthOfLIS(nums)
        println(result)
    }
}
