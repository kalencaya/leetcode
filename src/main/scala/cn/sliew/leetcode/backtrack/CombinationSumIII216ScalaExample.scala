package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 216. Combination Sum III medium
  */
object CombinationSumIII216ScalaExample {

    def combinationSum3(k: Int, n: Int): List[List[Int]] = {
        val nums = (1 to 9) toBuffer

        val result = new ListBuffer[List[Int]]()
        backtrack(new ListBuffer[Int](), n, k, 0, nums, result)
        result.toList
    }

    private def backtrack(temp: ListBuffer[Int], left: Int, count: Int, start: Int,  nums: mutable.Buffer[Int], result: ListBuffer[List[Int]]): Unit = {
        if (left == 0 && count == 0) {
            result += temp.toList
            return
        }

        if (left < 0 || count == 0) {
            return
        }

        for (i <- start until nums.length; if left >= nums(i)) {
            temp += nums(i)
            backtrack(temp, left - nums(i), count - 1, i + 1, nums, result)
            temp.remove(temp.length - 1)
        }
        for (num <- nums; if left >= num) {

        }

    }

    def main(args: Array[String]): Unit = {
        val k = 9
        val n = 45
        val result = combinationSum3(k, n)
        result.foreach(list => println(list.mkString("[", ",", "]")))
    }

}
