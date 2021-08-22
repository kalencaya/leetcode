package cn.sliew.leetcode.contest.weekly255

/**
  * 5850. Find Greatest Common Divisor of Array easy
  */
object FindGreatestCommonDivisorofArray5850ScalaExample {

    def findGCD(nums: Array[Int]): Int = {
        val sorted = nums.sorted
        val small = findDivisor(sorted(0))
        val large = findDivisor(sorted(sorted.length - 1))
        var smallIndex = small.length - 1
        var largeIndex = large.length - 1
        while (smallIndex >= 0 && largeIndex >= 0) {
            if (small(smallIndex) == large(largeIndex)) {
                return small(smallIndex)
            } else if (small(smallIndex) < large(largeIndex)) {
                largeIndex -= 1
            } else if (small(smallIndex) > large(largeIndex)) {
                smallIndex -= 1
            }
        }
        1
    }

    private def findDivisor(num: Int): Array[Int] = {
        val divisors = for (i <- 1 to num; if num % i == 0) yield i
        divisors.toArray
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(8, 5, 8, 7, 4)
        val result = findGCD(nums)
        println(result)
    }
}
