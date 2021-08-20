package cn.sliew.leetcode.backtrack

import java.util.concurrent.atomic.AtomicInteger

/**
  * 377. Combination Sum IV medium
  */
object CombinationSumIV377ScalaExample {

    def combinationSum4(nums: Array[Int], target: Int): Int = {
        val counter = new AtomicInteger()
        backtrack(target, 0, nums.sorted, counter)
        counter.get()
    }

    private def backtrack(left: Int, start: Int, nums: Array[Int], counter: AtomicInteger): Unit = {
        if (left == 0) {
            counter.incrementAndGet()
            return
        }

        for (i <- start until nums.length; if left >= nums(i)) {
            backtrack(left - nums(i), start, nums, counter)
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3)
        val target = 32
        val count = combinationSum4(nums, target)
        println(count)
    }

}
