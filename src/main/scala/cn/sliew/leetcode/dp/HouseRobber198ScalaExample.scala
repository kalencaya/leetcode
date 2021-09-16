package cn.sliew.leetcode.dp

/**
  * 198. House Robber medium
  */
object HouseRobber198ScalaExample {

    def rob(nums: Array[Int]): Int = {
        val dp = new Array[Int](nums.length)
        for (i <- 0 until dp.length) {
            dp(i) = -1
        }

        recurse(dp, 0, nums)
    }

    private def recurse(dp: Array[Int], start: Int, nums: Array[Int]) : Int = {
        if (start >= nums.length) {
            return 0
        }
        if (dp(start) != -1) {
            return dp(start)
        }

        var max = 0
        max = math.max(max, recurse(dp, start + 1, nums))
        max = math.max(max, nums(start) + recurse(dp, start + 2, nums))
        dp(start) = max

        max
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(2,7,9,3,1)
        val result = rob(nums)
        println(result)
    }
}
