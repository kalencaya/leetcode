package cn.sliew.leetcode.dp

/**
  * 213. House Robber II medium
  */
object HouseRobberII213ScalaExample {

    def rob(nums: Array[Int]): Int = {

        val dp = new Array[Int](nums.length + 1)
        for (i <- 0 until dp.length) {
            dp(i) = -1
        }
        dp(0) = 0
        var max = 0
        dp(1) = nums(0)
        max = math.max(max, recurse(dp, true, nums.length - 2, nums))
        dp(1) = 0
        max = math.max(max, recurse(dp, false, nums.length - 1, nums))
        max
    }

    private def recurse(dp: Array[Int], first: Boolean, start: Int, nums: Array[Int]): Int = {
        if (start < 0) {
            return 0
        }

        if (dp(start) != -1) {
            return dp(start)
        }

        var max = 0
        if (start == nums.length - 1) {
            if (!first) {
                max =  recurse(dp, first, start - 2, nums) + nums(start)
            } else {
                max = recurse(dp, first, start - 1, nums)
            }
        } else {
            max = math.max(max, recurse(dp, first, start - 2, nums) + nums(start))
            max = math.max(max, recurse(dp, first, start - 1, nums))
        }

        dp(start) = max
        max
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(2,3,2)
        val result = rob(nums)
        println(result)
    }

}
