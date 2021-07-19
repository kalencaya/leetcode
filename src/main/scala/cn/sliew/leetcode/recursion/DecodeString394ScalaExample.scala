package cn.sliew.leetcode.recursion

import java.util

/**
  * 394. Decode String medium
  */
object DecodeString394ScalaExample {

    private var index: Int = 0

    // s -> N ~ '[' ~ s ~ ']' ~ opt(s) | rep(char)
    def decodeString(s: String): String = {
        val list = new util.LinkedList[String]()
        while (index < s.length) {
            if (Character.isDigit(s.charAt(index))) {
                list.addLast(getDigits(s))
            } else if (s.charAt(index) == '[' || Character.isLetter(s.charAt(index))) {
                list.addLast(s.charAt(index).toString)
                index += 1
            } else {
                index += 1
                val sub = new util.LinkedList[String]()
                while (!list.peekLast().equals("[")) {
                    sub.addFirst(list.removeLast())
                }
                list.removeLast()
                val num = Integer.parseInt(list.removeLast())
                val sb = new StringBuilder()
                val subStr = mkString(sub)
                for (i <- 0 until num) {
                    sb.append(subStr)
                }
                list.addLast(sb.toString)
            }
        }
        mkString(list)
    }

    private def getDigits(s: String): String = {
        val sb = new StringBuilder()
        while (Character.isDigit(s.charAt(index))) {
            sb.append(s.charAt(index))
            index += 1
        }

        sb.toString
    }

    private def mkString(list: util.LinkedList[String]): String = {
        list.toArray.mkString
    }

    def main(args: Array[String]): Unit = {
        val s = "3[a2[c]]"
        val result = decodeString(s)
        println(result)
    }

}
