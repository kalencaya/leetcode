package cn.sliew.leetcode.backtrack

import scala.collection.mutable.ListBuffer

/**
  * 46. Permutations medium
  * tags: Backtracking
  */
object Permutations46ScalaExample {

    def permute(nums: Array[Int]): List[List[Int]] = {

        val result: ListBuffer[List[Int]] = new ListBuffer[List[Int]]
        backtrack(nums, new ListBuffer[Int], result)

        result.toList
    }

    private def backtrack(nums: Array[Int], temp: ListBuffer[Int], result: ListBuffer[List[Int]]): Unit = {
        if (nums.length == temp.length) {
            result += temp.toList
            return
        }

        for (num <- nums; if !temp.contains(num)) {
            temp += num
            backtrack(nums, temp, result)
            temp -= num
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3)
        val result = permute(nums)
        result.foreach(list => println(list.mkString("[", ",", "]")))
    }

}
