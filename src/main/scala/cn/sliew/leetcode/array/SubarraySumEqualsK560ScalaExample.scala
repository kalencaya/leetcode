package cn.sliew.leetcode.array

/**
  * 509.Subarray Sum Equals K medium
  */
object SubarraySumEqualsK560ScalaExample {

    def subarraySum(nums: Array[Int], k: Int): Int = {
        var count = 0
        for (i <- 0 until nums.length) {
            var sum = nums(i)
            if (sum == k){
                count += 1
            }
            for (j <- i + 1 until nums.length) {
                sum += nums(j)
                if (sum == k) {
                    count += 1
                }
            }
        }
        return count
    }

    def subarraySum2(nums: Array[Int], k: Int): Int = {
        var count = 0
        val sum = new Array[Int](nums.length + 1)
        sum(0) = 0
        for (i <- 1 to nums.length){
            sum(i) = sum(i - 1) + nums(i - 1)
        }

        for (i <- 0 until nums.length; j <- i + 1 to nums.length){
            if (sum(j) - sum(i) == k){
                count += 1
            }
        }

        return count
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 1, 1)
        val k = 2
        val result = subarraySum2(nums, k)
        println(result)
    }

}
