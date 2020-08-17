package cn.sliew.leetcode.array

/**
  * 643.Maximum Average Subarray I easy
  */
object MaximumAverageSubarrayI643ScalaExample {

    def findMaxAverage(nums: Array[Int], k: Int): Double = {
        var result = Int.MinValue
        var sum = nums.take(k).sum
        for (j <- k until nums.length) {
            result = math.max(result, sum)
            sum += nums(j) - nums(j - k)
        }
        result = math.max(result, sum)
        result * 1.0 / k
    }


    def main(args: Array[String]): Unit = {
        val nums: Array[Int] = Array(0, 1, 1, 3, 3)
        val k = 4
        val result = findMaxAverage(nums, k)
        println(result)
    }

}
