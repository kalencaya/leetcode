package cn.sliew.leetcode.dp

import scala.collection.mutable

/**
  * 91. Decode Ways medium
  */
object DecodeWays91ScalaExample {

    private val map = new mutable.HashMap[Int, Char]()
    map += 1 -> 'A'
    map += 2 -> 'B'
    map += 3 -> 'C'
    map += 4 -> 'D'
    map += 5 -> 'E'
    map += 6 -> 'F'
    map += 7 -> 'G'
    map += 8 -> 'H'
    map += 9 -> 'I'
    map += 10 -> 'J'
    map += 11 -> 'K'
    map += 12 -> 'L'
    map += 13 -> 'M'
    map += 14 -> 'N'
    map += 15 -> 'O'
    map += 16 -> 'P'
    map += 17 -> 'Q'
    map += 18 -> 'R'
    map += 19 -> 'S'
    map += 20 -> 'T'
    map += 21 -> 'U'
    map += 22 -> 'V'
    map += 23 -> 'W'
    map += 24 -> 'X'
    map += 25 -> 'Y'
    map += 26 -> 'Z'

    def numDecodings(s: String): Int = {
        val dp = new mutable.HashMap[String, Int]()
        recurse(dp, s)
    }

    private def recurse(dp: mutable.HashMap[String, Int], s: String): Int = {
        if (dp.contains(s)) {
            return dp.get(s).get
        }

        if (s.length == 0 || s.startsWith("0")) {
            dp.put(s, 0)
        } else if (s.length == 1 && isValid(s)) {
            dp.put(s, 1)
        } else if (s.length == 2) {
            var count = 0
            if (isValid(s.substring(0, 1)) && isValid(s.substring(1))) {
                count +=1
            }
            if (isValid(s)) {
                count += 1
            }
            dp.put(s, count)
        }
        else {
            var count = 0
            val digit1 = s.substring(0, 1)
            if (isValid(digit1)) {
                count += recurse(dp, s.substring(1))
            }

            val digit2 = s.substring(0, 2)
            if (isValid(digit2)) {
                count += recurse(dp, s.substring(2))
            }
            dp.put(s, count)
        }
        dp.get(s).get
    }

    private def isValid(digits: String): Boolean = {
        !digits.startsWith("0") && Integer.parseInt(digits) <= 26
    }

    def main(args: Array[String]): Unit = {
        val s = "0"
        val result = numDecodings(s)
        println(result)
    }

}
