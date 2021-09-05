package cn.sliew.leetcode.contest.weekly257

object CountSpecialQuadruplets5863ScalaExample {

    def countQuadruplets(nums: Array[Int]): Int = {
//        val sorted = nums.sorted
        println(nums.mkString(","))
        var count = 0
        for (first <- 0 until nums.length - 3;
             second <- first + 1 until nums.length - 2;
             third <- second + 1 until nums.length - 1;
             forth <- third + 1 until nums.length) {
            if (nums(first) + nums(second) + nums(third) == nums(forth)) {
                println(s"${first} + ${second} + ${third} = ${forth}")
                count += 1
            }
        }

        count
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(28, 8, 49, 85, 37, 90, 20, 8)
        val result = countQuadruplets(nums)
        println(result)
    }

}
