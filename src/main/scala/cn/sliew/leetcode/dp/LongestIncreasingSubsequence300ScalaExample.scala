package cn.sliew.leetcode.dp

/**
  * 300. Longest Increasing Subsequence mediym
  */
object LongestIncreasingSubsequence300ScalaExample {

    def lengthOfLIS(nums: Array[Int]): Int = {
        if (nums.length == 1) {
            return 1
        }

//        val dp = Array.ofDim[Int](nums.length, nums.length)

        val dp = new Array[(Int, Int)](nums.length)
//        dfs(dp, nums(0), 1, nums)
        1
    }

    private def dfs(dp: Array[(Int, Int)], num: Int, start: Int, nums: Array[Int]): Int = {
        if (start == nums.length) {
            return 0
        }

        if (dp(start) != null) {
            return dp(start)._2
        }

//        if (num < nums(start)) {
//            dp(start) = 1 + dfs(dp, nums(start), start + 1, nums)
//        } else {
//            dp(start) = 1 + dfs(dp, num, start + 1, nums)
//        }

        dp(start)
        num
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(10,9,2,5,3,7,101,18)
        val result = lengthOfLIS(nums)
        println(result)
    }
}
