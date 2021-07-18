package cn.sliew.leetcode.recursion

/**
  * 326. Power of Three easy
  */
object PowerofThree326ScalaExample {

    def isPowerOfThree(n: Int): Boolean = {
        if (n == 0) {
            return false
        }
        var temp = n
        while (temp % 3 == 0) {
            temp = temp / 3
        }
        temp == 1
    }

    def main(args: Array[String]): Unit = {
        val n = 9
        val result = isPowerOfThree(n)
        println(result)
    }
}
