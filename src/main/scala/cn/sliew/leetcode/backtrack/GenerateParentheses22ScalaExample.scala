package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 22. Generate Parentheses medium
  * tags: String, Backtracking
  */
object GenerateParentheses22ScalaExample {

    def generateParenthesis(n: Int): List[String] = {
        val result: ListBuffer[String] = new ListBuffer[String]()
        backtrack(n * 2, n, 0, mutable.Buffer[Char](), result)
        result.toList
    }

    private def backtrack(length: Int, left: Int, right: Int, temp: mutable.Buffer[Char], result: ListBuffer[String]): Unit = {
        if (length == 0) {
            result += new String(temp.toArray)
            return
        }
        var quotes: Array[Char] = Array()
        if (left > 0) {
            quotes = quotes :+ '('
        }
        if (right > 0) {
            quotes = quotes :+ ')'
        }

        for (quote <- quotes) {
            temp.append(quote)
            if (quote == '(') {
                backtrack(length - 1, left - 1, right + 1, temp, result)
            } else {
                backtrack(length - 1, left, right - 1, temp, result)
            }

            temp.remove(temp.length - 1)
        }
    }


    def main(args: Array[String]): Unit = {
        val n = 3
        val result = generateParenthesis(n)
        result.foreach(println)
    }
}
