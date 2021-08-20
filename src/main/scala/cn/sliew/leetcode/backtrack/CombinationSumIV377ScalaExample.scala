package cn.sliew.leetcode.backtrack

import java.util.concurrent.atomic.AtomicInteger

/**
  * 377. Combination Sum IV medium
  */
object CombinationSumIV377ScalaExample {

    def combinationSum4(nums: Array[Int], target: Int): Int = {
        recurse(nums.sorted, target, 0)
    }

    private def recurse(sortedNums: Array[Int], target: Int, start: Int): Int = {
        if (start == sortedNums.length) {
            if (target % sortedNums(start - 1) == 0) {
                return 1
            } else {
                return 0
            }
        }
        var count = 0
        for (i <- 0 to target / sortedNums(start)) {
            count += recurse(sortedNums, target - i * sortedNums(start), i + 1)
        }
        count
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3)
        val target = 32
        val count = combinationSum4(nums, target)
        println(count)
    }

}
