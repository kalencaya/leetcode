package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * 47. Permutations II medium
  * tags: Backtracking
  */
object PermutationsII47ScalaExample {

    def permuteUnique(nums: Array[Int]): List[List[Int]] = {
        val result: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
        backtrack(nums, nums.length, mutable.Buffer[Int](), result)
        result.toList
    }

    private def backtrack(nums: Array[Int], left: Int, temp: mutable.Buffer[Int], result: ListBuffer[List[Int]]): Unit = {
        if (left == 0) {
            val option = result.find(list => list.equals(temp))
            if (option.isEmpty) {
                result += temp.toList
            }
            return
        }

        for (i <- 0 until nums.length) {
            temp += nums(i)
            val list: ArrayBuffer[Int] = new ArrayBuffer[Int](nums.length)
            list ++= nums
            list.remove(i)
            backtrack(list.toArray, left - 1, temp, result)
            temp.remove(temp.length - 1)
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 1, 2)
        val result = permuteUnique(nums)
        result.foreach(list => println(list.mkString("[", ",", "]")))
    }

}
