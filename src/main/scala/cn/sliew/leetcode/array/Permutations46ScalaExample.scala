package cn.sliew.leetcode.array

import scala.collection.mutable

/**
  * 46. Permutations medium
  */
object Permutations46ScalaExample {

    def permute(nums: Array[Int]): List[List[Int]] = {
        val result = mutable.Buffer[List[Int]]()
        backtrack(mutable.Buffer[Int](), nums, result)
        result.toList
    }

    def backtrack(temp: mutable.Buffer[Int], nums: Array[Int], result: mutable.Buffer[List[Int]]): Unit = {
        if (temp.length == nums.length) {
            result += temp.toList
            return
        }
        for (num <- nums; if !temp.contains(num)) {
            temp += num
            backtrack(temp, nums, result)
            temp -= num
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3)
        val result = permute(nums)
        result.foreach(array => println(array.mkString("[", ",", "]")))
    }
}
