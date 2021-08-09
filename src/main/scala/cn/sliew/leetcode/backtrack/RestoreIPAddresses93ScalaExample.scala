package cn.sliew.leetcode.backtrack

import scala.collection.mutable.ListBuffer

/**
  * 93. Restore IP Addresses medium
  */
object RestoreIPAddresses93ScalaExample {

    def restoreIpAddresses(s: String): List[String] = {
        // 中间结果
        val temp = new StringBuilder()
        val chars = new StringBuilder(s)
        val result = new ListBuffer[String]()
        backtrack(temp, 4, 0, chars, result)

        result.toList
    }

    private def backtrack(temp: StringBuilder, dotLeft: Int, index: Int, chars: StringBuilder, result: ListBuffer[String]): Unit = {
        if (dotLeft == 0 && index == chars.length) {
            result += temp.toString
            return
        }
        if (dotLeft <= 0 || index >= chars.length) {
            return
        }

        for (i <- index until chars.length) {
            temp.append(chars(i))
            backtrack(temp, dotLeft, i + 1, chars, result)
            temp.deleteCharAt(temp.length - 1)

            temp.append(".")
            temp.append(chars(i))
            backtrack(temp, dotLeft - 1, i + 1, chars, result)
            temp.deleteCharAt(temp.length - 1)
            temp.deleteCharAt(temp.length - 1)
        }
    }

    def main(args: Array[String]): Unit = {
        val s = "25525"
        val result = restoreIpAddresses(s)
        println(result.mkString("[", ", ", "]"))
    }


}
