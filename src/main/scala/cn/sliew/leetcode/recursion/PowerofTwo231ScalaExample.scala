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

    def isPowerOfTwo2(n: Int): Boolean = {
        if (n <= 0) {
            return false
        }

        var temp = n
        while (temp > 1 && (temp % 2 == 0)) {
            temp = temp >>> 1
        }
        temp == 1
    }

    def main(args: Array[String]): Unit = {
        val n = 3
        val result = isPowerOfTwo2(n)

        println(result)
    }
}
