package cn.sliew.leetcode.backtrack

import scala.collection.mutable.ListBuffer

/**
  * 93. Restore IP Addresses medium
  */
object RestoreIPAddresses93ScalaExample {

    def restoreIpAddresses(s: String): List[String] = {
        // 中间结果
        val temp = new StringBuilder()
        val result = new ListBuffer[String]()
        backtrack(temp, 3, 0, s, result)

        result.toList
    }

    private def backtrack(temp: StringBuilder, dotLeft: Int, start: Int, chars: String, result: ListBuffer[String]): Unit = {
        if (dotLeft == 0) {
            result += temp.toString
            return
        }
        var left = dotLeft
        for (i <- start until chars.length) {
            temp.append(chars(i))
            backtrack(temp + chars(i), left, start + 1, chars, result)
            temp.deleteCharAt(temp.length - 1)
            if (!temp.isEmpty && !temp.endsWith(".")) {
                temp.append(".")
                left -= 1
//                temp.append(chars(i))
            }
        }
    }

    def main(args: Array[String]): Unit = {
        val s = "25525"
        val result = restoreIpAddresses(s)
        println(result.mkString("[", ", ", "]"))
    }


}
