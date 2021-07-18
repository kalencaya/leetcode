package cn.sliew.leetcode.recursion

import scala.collection.mutable.ListBuffer

/**
  * 241. Different Ways to Add Parentheses medium
  *
  * https://code.google.com/archive/p/aviator/wikis/User_Guide_zh.wiki
  */
object DifferentWaystoAddParentheses241ScalaExample {

    def diffWaysToCompute(expression: String): List[Int] = {
        if (expression == null || expression.length == 0) {
            return List()
        }
        var result = new ListBuffer[Int]()
        val charArray = expression.toCharArray
        val option = charArray.find(char => !Character.isDigit(char))
        if (option.isEmpty) {
            return List(Integer.parseInt(expression))
        }
        for (i <- 0 until charArray.length; if !Character.isDigit(charArray(i))) {
            val left = diffWaysToCompute(expression.substring(0, i))
            val right = diffWaysToCompute(expression.substring(i + 1))
            result ++= quadrature(left, right, charArray(i))
        }
        result.toList
    }

    private def quadrature(left: List[Int], right: List[Int], operator: Char): List[Int] = {
        if (left == null || left.isEmpty) {
            return right
        }
        if (right == null || right.isEmpty) {
            return left
        }
        val result = new ListBuffer[Int]()
        for (numLeft <- left) {
            for (numRight <- right) {
                if (operator == '-') {
                    result += numLeft - numRight
                } else if (operator == '+') {
                    result += numLeft + numRight
                } else if (operator == '*') {
                    result += numLeft * numRight
                }
            }
        }
        result.toList
    }

    def main(args: Array[String]): Unit = {
        val expression = "1+2+3"
        val result = diffWaysToCompute(expression)
        println(result.mkString("[", ",", "]"))
    }


}
