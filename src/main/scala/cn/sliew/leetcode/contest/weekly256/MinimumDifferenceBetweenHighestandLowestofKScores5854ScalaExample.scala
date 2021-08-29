package cn.sliew.leetcode.contest.weekly256

/**
  * 5854. Minimum Difference Between Highest and Lowest of K Scores easy
  */
object MinimumDifferenceBetweenHighestandLowestofKScores5854ScalaExample {

    def minimumDifference(nums: Array[Int], k: Int): Int = {
        if (k == 1) {
            return 0
        }

        val sorted = nums.sorted(Ordering.Int.reverse)
        if (sorted.length <= k) {
            return sorted(0) - sorted(sorted.length - 1)
        }
        var left = 0
        var min = Int.MaxValue
        while (left + k <= sorted.length) {
            min = math.min(min, sorted(left) - sorted(left + k - 1))
            left += 1
        }
        min
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(8216, 18083, 81861, 92320, 30808, 4467, 36436, 7960)
        val k = 8

        val result = minimumDifference(nums, k)
        println(result)
    }
}
