package cn.sliew.leetcode.backtrack

import scala.collection.mutable.ListBuffer

object AdditiveNumber306ScalaExample {

  def isAdditiveNumber(num: String): Boolean = {

    backtrack(new ListBuffer[Int](), 0, num)
  }

  private def backtrack(nums: ListBuffer[Int], start: Int, numString: String): Boolean = {
    if (start == numString.length) {
      return false
    }
    if (nums.length == 2) {
      return isAdditiveSequence(nums(0), nums(1), numString.substring(start))
    }

    for (end <- start until numString.length) {
      val num = numString.substring(start, `end` + 1).toInt
      nums += num
      if (backtrack(nums, `end` + 1, numString)) {
        return true
      }
      nums.remove(nums.length - 1)
    }
    false
  }

  private def isAdditiveSequence(first: Int, second: Int, left: String): Boolean = {
    if (left.length == 0) {
      return true
    }
    val third = first + second
    if (left.startsWith(third.toString)) {
      return isAdditiveSequence(second, third, left.substring(third.toString.length))
    }
    false
  }


  def main(args: Array[String]): Unit = {
    val num = "1023"
    val result = isAdditiveNumber(num)
    println(result)
  }

}
