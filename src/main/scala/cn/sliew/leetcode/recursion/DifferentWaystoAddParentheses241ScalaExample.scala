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

    val option = evelate(expression)
    if (option.isDefined) {
      return List(option.get)
    }

    val result = new ListBuffer[Int]
    val sb = new StringBuilder
    for (index <- 0 until expression.length) {
      // 处理
      println(index)
      // 不处理
    }

    result.toList
  }

  private def evelate(expression: String): Option[Int] = {
    val strings = expression.split("-|\\+|\\*")
    if (strings == null || strings.length != 2) {
      return None
    }

    val subtract = expression.indexOf("-")
    val add = expression.indexOf("+")
    val multi = expression.indexOf("*")

    if (subtract != -1 && add == -1 && multi == -1) {
      return Some(Integer.parseInt(strings(0)) - Integer.parseInt(strings(1)))
    }
    if (subtract == -1 && add != -1 && multi == -1) {
      return Some(Integer.parseInt(strings(0)) + Integer.parseInt(strings(1)))
    }
    if (subtract == -1 && add == -1 && multi != -1) {
      return Some(Integer.parseInt(strings(0)) * Integer.parseInt(strings(1)))
    }

    None
  }

  def main(args: Array[String]): Unit = {
    val expression = "1+2+3"
    val result = diffWaysToCompute(expression)
    println(result.mkString("[", ",", "]"))
  }


}
