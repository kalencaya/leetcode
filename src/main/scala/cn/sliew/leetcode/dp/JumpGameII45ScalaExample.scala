package cn.sliew.leetcode.dp

import scala.collection.mutable.ArrayBuffer

object JumpGameII45ScalaExample {

    def jump(nums: Array[Int]): Int = {
        val dp = new ArrayBuffer[Int](nums.length)
        for (i <- 0 until nums.length) {
            dp += -1
        }

        recurse(dp, 0, nums)
    }

    private def recurse(dp: ArrayBuffer[Int], start: Int, nums: Array[Int]): Int = {
        if (start >= nums.length - 1) {
            return 0
        }

        if (dp(start) != -1) {
            return dp(start)
        }
        var min = Int.MaxValue
        for (i <- 1 to nums(start)) {
            val step = recurse(dp, start + i, nums)
            if (step != Int.MaxValue) {
                min = math.min(step + 1, min)
            }
        }
        dp.update(start, min)
        min
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(2, 3, 0, 1, 4)
        val result = jump(nums)
        println(result)
    }

}
