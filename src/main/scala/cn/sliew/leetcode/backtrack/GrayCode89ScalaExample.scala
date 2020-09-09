package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 89. Gray Code medium
  * tags: Backtracking
  */
object GrayCode89ScalaExample {

    var num = 0

    def grayCode(n: Int): List[Int] = {
        val result: ListBuffer[Int] = new ListBuffer[Int]
        backtrack(n, result)
        result.toList
    }

    private def backtrack(left: Int, result: ListBuffer[Int]): Unit = {
        if (left == 0) {
            result += num
            return
        }
        backtrack(left - 1, result)
        num = num ^ (1 << left - 1)
        backtrack(left - 1, result)
    }

    /**
      * 当n = 3时，可以利用n = 2时的结果。
      * 当n = 2 时，00,01,11,10 -> (000,001,011,010) (110,111,101,100)
      * 当n = 3 时，000,001,011,010，100,101,111,110，这样中间位置的就不能连接在一起了，
      * 但是通过反转 000,001,011,010，110,111,101,100就解决这个问题
      */
    def grayCode2(n: Int): List[Int] = {
        val result: ListBuffer[Int] = new ListBuffer[Int]
        result += 0
        for (i <- 0 until n; j <- result.length - 1 to 0 by -1) {
            result += result(j) | 1 << i
        }
        result.toList
    }

    def grayCode3(n: Int): List[Int] = {
        val result: ListBuffer[Int] = new ListBuffer[Int]
        if (n == 0) {
            result += 0
            return result.toList
        }
        backtrack2(0, n, result, Array(0))
        result.toList
    }

    private def backtrack2(start: Int, n: Int, result: ListBuffer[Int], label: Array[Int]): Unit = {
        if (start == n) {
            var c = 0
            for (i <- 0 until n) {
                val a = label(i) * math.pow(2, i)
                c += a
            }
            result
        }
    }

    def main(args: Array[String]): Unit = {
        val n = 2
        val result = grayCode(n)
        println(result.mkString("[", ",", "]"))
    }

}
