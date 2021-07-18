package cn.sliew.leetcode.recursion

/**
  * 342. Power of Four easy
  */
object PowerofFour342ScalaExample {

    def isPowerOfFour(n: Int): Boolean = {
        if (n == 0) {
            return false
        }
        if ((n & (n - 1)) != 0) {
            return false
        }
        val length = Integer.numberOfTrailingZeros(n)
        length % 2 == 0
    }

    def main(args: Array[String]): Unit = {
        val n = 8
        val result = isPowerOfFour(n)
        println(result)
    }
}
