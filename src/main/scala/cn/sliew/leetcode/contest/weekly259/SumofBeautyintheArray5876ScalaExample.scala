package cn.sliew.leetcode.contest.weekly259

import scala.collection.mutable

/**
  * 5876. Sum of Beauty in the Array medium
  */
object SumofBeautyintheArray5876ScalaExample {

    def sumOfBeauties(nums: Array[Int]): Int = {
        var sum = 0
        val mem = buildMem(nums)
        for (i <- 1 to nums.length - 2) {
            sum += beauty(mem, i, nums)
        }
        sum
    }

    private def buildMem(nums: Array[Int]): mutable.HashMap[Int, (Int, Int)] = {
        val mem = new mutable.HashMap[Int, (Int, Int)]()
        mem.put(1, (nums(0), findMin(2, nums)))
        for (i <- 2 to nums.length - 2) {
            val leftRightTuple = mem.get(i - 1).get
            val left = math.max(leftRightTuple._1, nums(i - 1))
            var right = 0
            if (leftRightTuple._2 == nums(i)) {
                right = findMin(i + 1, nums)
            } else {
                right = leftRightTuple._2
            }
            mem.put(i, (left, right))
        }
        mem
    }

    private def findMin(start: Int, nums: Array[Int]): Int = {
        var min = Int.MaxValue
        for (i <- start until nums.length) {
            min = math.min(min, nums(i))
        }
        min
    }

    private def beauty(mem: mutable.HashMap[Int, (Int, Int)], index: Int, nums: Array[Int]): Int = {
        val value = mem.get(index).get
        if (value._1 < nums(index) && nums(index) < value._2) {
            return 2
        }
        if (nums(index - 1) < nums(index) && nums(index) < nums(index + 1)) {
            1
        } else {
            0
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(2, 4, 6, 5)
        val result = sumOfBeauties(nums)
        println(result)
    }

}
