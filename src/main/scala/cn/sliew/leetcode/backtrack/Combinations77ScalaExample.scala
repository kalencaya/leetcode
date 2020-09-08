package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 77.Combinations medium
  * tags: Backtracking
  */
object Combinations77ScalaExample {

    def combine(n: Int, k: Int): List[List[Int]] = {
        val nums = (1 to n).toArray
        val result = new ListBuffer[List[Int]]()
        backtrack(0, nums.length, nums, k, new ListBuffer[Int], result)
        result.toList
    }

    private def backtrack(start: Int, end: Int, nums: Array[Int], left: Int, temp: mutable.Buffer[Int], result: mutable.Buffer[List[Int]]): Unit = {
        if (left == 0) {
            result += temp.toList
            return
        }
        for (i <- start until end) {
            temp += nums(i)
            backtrack(i + 1, end, nums, left - 1, temp, result)
            temp -= nums(i)
        }
    }


    def main(args: Array[String]): Unit = {
        val n = 4
        val k = 2
        val result = combine(n, k)
        result.foreach(list => println(list.mkString("[", ",", "]")))
    }

}
