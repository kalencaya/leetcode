package cn.sliew.leetcode.recursion

/**
  * 231.Power of Two easy
  */
object PowerofTwo231ScalaExample {

    def isPowerOfTwo(n: Int): Boolean = {
        if (n <= 0) {
            false
        } else {
            (n & (n - 1)) == 0
        }
    }

    def main(args: Array[String]): Unit = {
        val n = 3
        val result = isPowerOfTwo(n)

        println(result)
    }
}
