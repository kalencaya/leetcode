package cn.sliew.leetcode.contest.weekly259

import scala.util.control.Breaks.{break, breakable}

/**
  * 5876. Sum of Beauty in the Array medium
  */
object SumofBeautyintheArray5876ScalaExample {

    def sumOfBeauties(nums: Array[Int]): Int = {
        var sum = 0
        for (i <- 1 to nums.length - 2) {
            sum += beauty(i, nums)
        }
        sum
    }

    private def beauty(index: Int, nums: Array[Int]): Int = {
        val beauty = 0
        if (nums(index - 1) >= nums(index) || nums(index) >= nums(index + 1)) {
            return beauty
        }
        for (j <- 0 until index) {
            if (nums(j) >= nums(index)) {
                return 1
            }
        }
        for (k <- index + 1 until nums.length) {
            if (nums(index) >= nums(k)) {
                return 1
            }
        }

        2
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(2, 4, 6, 5)
        val result = sumOfBeauties(nums)
        println(result)
    }

}
