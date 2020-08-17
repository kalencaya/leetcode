package cn.sliew.leetcode.array

/**
  * 628. Maximum Product of Three Numbers easy
  */
object MaximumProductofThreeNumbers628ScalaExample {

    /**
      * 超时，未通过
      */
    def maximumProduct(nums: Array[Int]): Int = {
        var result = Int.MinValue
        for (i <- 0 until nums.length - 2; j <- i + 1 until nums.length - 1; k <- j + 1 until nums.length) {
            result = math.max(result, nums(i) * nums(j) * nums(k))
        }
        result
    }

    def maximumProduct2(nums: Array[Int]): Int = {
        var result = Int.MinValue
        var sorted = nums.sorted
        for (i <- 0 until sorted.length - 2; j <- i + 1 until sorted.length - 1) {
            result = math.max(result, sorted(i) * sorted(j) * sorted(sorted.length - 1))
        }
        result
    }
    def main(args: Array[String]): Unit = {
        val nums: Array[Int] = Array(1, 2, 3, 4)
        val result = maximumProduct2(nums)
        println(result)
    }

}
