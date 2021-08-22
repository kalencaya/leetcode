package cn.sliew.leetcode.contest.weekly255

import scala.collection.mutable.ListBuffer

/**
  * 5851. Find Unique Binary String medium
  */
object FindUniqueBinaryString5851ScalaExample {

    def findDifferentBinaryString(nums: Array[String]): String = {
        val result = new ListBuffer[String]()
        backtrack(new StringBuilder(), 0, nums.length, nums, result)
        result(0)
    }

    private def backtrack(temp: StringBuilder, start: Int, total: Int, nums: Array[String], result: ListBuffer[String]): Unit = {
        if (result.size > 0) {
            return
        }
        if (start == total) {
            if (nums.length == 0) {
                result += temp.toString
                return
            }
            return
        }

        var leftNums = nums
        for (i <- start until total) {
            temp.append('0')
            leftNums = nums.filter(num => num.charAt(i) == '0')
            backtrack(temp, i + 1, total, leftNums, result)
            temp.deleteCharAt(temp.length - 1)

            temp.append('1')
            leftNums = nums.filter(num => num.charAt(i) == '1')
            backtrack(temp, i + 1, total, leftNums, result)
            temp.deleteCharAt(temp.length - 1)
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array("111","011","001")
        val result = findDifferentBinaryString(nums)
        println(result)
    }
}
