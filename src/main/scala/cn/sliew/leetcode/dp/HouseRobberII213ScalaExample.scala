package cn.sliew.leetcode.dp

/**
  * 213. House Robber II medium
  */
object HouseRobberII213ScalaExample {

    def rob(nums: Array[Int]): Int = {
        if (nums.length == 0) {
            return 0
        }
        if (nums.length < 2) {
            return nums(0)
        }

        val dp1 = new Array[Int](nums.length + 1)
        val dp2 = new Array[Int](nums.length + 1)
        for (i <- 0 until dp1.length) {
            dp1(i) = -1
        }
        for (i <- 0 until dp2.length) {
            dp2(i) = -1
        }

        dp1(0) = 0
        dp1(1) = nums(0)
        dp2(0) = 0
        dp2(1) = 0
        for (i <- 2 to nums.length) {
            dp1(i) = math.max(dp1(i - 1), dp1(i - 2) + nums(i - 1))
            dp2(i) = math.max(dp2(i - 1), dp2(i - 2) + nums(i - 1))
        }
        math.max(dp1(nums.length - 1), dp2(nums.length))
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3)
        val result = rob(nums)
        println(result)
    }

}
