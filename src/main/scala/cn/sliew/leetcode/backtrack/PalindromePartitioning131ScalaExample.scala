package cn.sliew.leetcode.backtrack

import scala.collection.mutable.ListBuffer

/**
  * 131. Palindrome Partitioning medium
  */
object PalindromePartitioning131ScalaExample {

  def partition(s: String): List[List[String]] = {
    val result = new ListBuffer[List[String]]()
    backtrack(new ListBuffer[String](), 0, s, result)
    result.toList
  }

  private def backtrack(temp: ListBuffer[String], start: Int, s: String, result: ListBuffer[List[String]]): Unit = {
    if (start >= s.length) {
      result += temp.toList
      return
    }

    for (end <- start until s.length) {
      var substring = s.substring(start, `end` + 1)
      if (isPalindrome(s, start, `end`)) {
        temp += substring
        backtrack(temp, `end` + 1, s, result)
        temp.remove(temp.length - 1)
      }
    }
  }

  private def isPalindrome(s: String, start: Int, end: Int): Boolean = {
    var left = start
    var right = end
    while (left <= right) {
      if (s.charAt(left) == s.charAt(right)) {
        left += 1
        right -= 1
      } else {
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val s = "aabbb"
    val result = partition(s)
    result.foreach(list => println(list.mkString("[", ",", "]")))
  }
}
