package cn.sliew.leetcode.array

import scala.util.control.Breaks._

/**
  * 457. Circular Array Loop medium
  * todo 没解决
  */
object CircularArrayLoop457ScalaExample {

    def circularArrayLoop(nums: Array[Int]): Boolean = {
        if (nums.length < 2) {
            return false;
        }
        val n = nums.length
        for (i <- 0 until n; if (nums(i) != 0)) {
            // j 慢指针，每轮走一步，k 快指针，每轮走两步
            var j = i
            var k = getIndex(i, nums)
            breakable {
                while (nums(j) * nums(i) > 0 && nums(getIndex(k, nums)) * nums(i) > 0) {
                    if (j == k) {
                        if (j == getIndex(j, nums)) {
                            break
                        }
                        return true
                    }
                    j = getIndex(j, nums)
                    k = getIndex(getIndex(k, nums), nums)
                }
            }

            j = i
            val value = nums(i)
            while (nums(j) * value > 0) {
                val next = getIndex(j, nums)
                nums(j) = 0
                j = next
            }
        }

        false
    }

    private def getIndex(i: Int, nums: Array[Int]): Int = {
        val n = nums.length
        if (i + nums(i) >= 0)
            (i + nums(i)) % n
        else
            n + ((i + nums(i)) % n)
    }


    def main(args: Array[String]): Unit = {
        val nums: Array[Int] = Array(1, 1, 1, 1, 1, 1, 1, 1, 1, -5)
        val result = circularArrayLoop(nums)
        println(result)
    }
}
