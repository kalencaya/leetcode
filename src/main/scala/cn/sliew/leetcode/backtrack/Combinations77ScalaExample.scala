package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 77.Combinations medium
  */
object Combinations77ScalaExample {


    def combine(n: Int, k: Int): List[List[Int]] = {
        val nums = (1 to n) toArray
        val combs = new ListBuffer[List[Int]]()
        val comb = new mutable.HashSet[Int]()
        backtrack(combs, comb, nums, 0, nums.length - 1, k)
        combs.toList
    }

    private def backtrack(combs: ListBuffer[List[Int]], comb: mutable.HashSet[Int], nums: Array[Int], start: Int, end: Int, left: Int): Unit = {
        if (left == 0) {
            combs += comb.toList
            return
        }

        for (i <- start to end) {
            comb += nums(i)
            backtrack(combs, comb, nums, i + 1, end, left - 1)
            comb -= nums(i)
        }

    }

    def main(args: Array[String]): Unit = {
        val n = 4
        val k = 2
        val result = combine(n, k)
        result.foreach(list => println(list.mkString(", ")))
    }

}
