package cn.sliew.leetcode.array

/**
  * 581. Shortest Unsorted Continuous Subarray easy
  */
object ShortestUnsortedContinuousSubarray581ScalaExample {

    def findUnsortedSubarray(nums: Array[Int]): Int = {
        var left = nums.length - 1
        var right = 0
        for (i <- 0 until nums.length - 1; j <- i + 1 until nums.length) {
            if (nums(i) > nums(j)) {
                left = math.min(left, i)
                right = math.max(right, j)
            }
        }
        if (right - left > 0) {
            right - left + 1
        } else {
            0
        }
    }

    def main(args: Array[String]): Unit = {
        //        val nums: Array[Int] = Array(1, 2, 3, 4)
        val nums: Array[Int] = Array(2, 6, 4, 8, 10, 9, 15)
        //        val nums: Array[Int] = Array(3, 2, 3, 2, 4)
        val result = findUnsortedSubarray(nums)
        println(result)
    }

}
