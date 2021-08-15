package cn.sliew.leetcode.contest.weekly254

import scala.collection.mutable.ListBuffer

object ArrayWithElementsNotEqualtoAverageofNeighbors5832ScalaExample {

    def rearrangeArray(nums: Array[Int]): Array[Int] = {
        val sorted = nums.sorted
        val middle = nums.length / 2
        var left = 0
        var right = middle + 1
        val result = new ListBuffer[Int]()
        result += sorted(middle)
        while (left < middle || right < nums.length) {
            if (left < middle) {
                result += sorted(left)
                left += 1
            }
            if (right < nums.length) {
                result += sorted(right)
                right += 1
            }
        }
        result.toArray
    }


    def main(args: Array[String]): Unit = {
        val nums = Array(6, 2, 0, 9, 7)
        val result = rearrangeArray(nums)
        println(result.mkString("[", ",", "]"))
    }
}
