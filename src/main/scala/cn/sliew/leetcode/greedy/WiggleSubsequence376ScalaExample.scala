package cn.sliew.leetcode.greedy

/**
  * 376. Wiggle Subsequence medium
  * tags: Dynamic Programming, Greedy
  */
object WiggleSubsequence376ScalaExample {

    def wiggleMaxLength(nums: Array[Int]): Int = {
        if (nums.length < 2) {
            return nums.length
        }
        1 + math.max(recurse(nums, 0, true), recurse(nums, 0, false))
    }

    private def recurse(nums: Array[Int], index: Int, desc: Boolean): Int = {
        var max = 0
        for (i <- index + 1 until nums.length) {
            if ((desc && nums(i) > nums(i - 1)) || (!desc && nums(i) < nums(i - 1))) {
                max = math.max(max, 1 + recurse(nums, i, !desc))
            }
        }
        max
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)
        val result = wiggleMaxLength(nums)
        println(result)
    }
}
