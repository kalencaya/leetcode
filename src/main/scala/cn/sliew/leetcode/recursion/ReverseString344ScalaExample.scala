package cn.sliew.leetcode.recursion

/**
  * 344. Reverse String easy
  */
object ReverseString344ScalaExample {

    def reverseString(s: Array[Char]): Unit = {
        if (s == null || s.length <= 1) {
            return
        }

        val length = s.length
        val middle = length / 2
        for (i <- 0 until middle) {
            val temp = s(i)
            s(i) = s(length - 1 - i)
            s(length - 1 - i) = temp
        }
    }

    def main(args: Array[String]): Unit = {
        val s = Array('h','e','l','l','o')
        reverseString(s)
        println(s.mkString(""))
    }
}
