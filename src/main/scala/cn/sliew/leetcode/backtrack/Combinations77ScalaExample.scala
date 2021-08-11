package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 77.Combinations medium
  * tags: Backtracking
  */
object Combinations77ScalaExample {

    def combine(n: Int, k: Int): List[List[Int]] = {
        val nums = (1 to n) toBuffer
        val result = new ListBuffer[List[Int]]()
        val temp = new ListBuffer[Int]()
        backtrack(temp, k, 0, nums, result)
        result.toList
    }

    private def backtrack(temp: ListBuffer[Int], left: Int, start: Int, nums: mutable.Buffer[Int], result: ListBuffer[List[Int]]): Unit = {
        if (left == 0) {
            result += temp.toList
            return
        }
        for (i <- start until nums.length) {
            temp += nums(i)
            backtrack(temp, left - 1, i + 1, nums, result)
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
