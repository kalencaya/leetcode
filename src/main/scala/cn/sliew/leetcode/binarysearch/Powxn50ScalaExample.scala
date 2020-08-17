package cn.sliew.leetcode.binarysearch

/**
  * 50. Pow(x, n) medium
  */
object Powxn50ScalaExample {

    def myPow(x: Double, n: Int): Double = {
        if (n == 0) {
            return 1.0
        }
        if (n < 0)
            return 1 / x * myPow(1 / x, -(n + 1))

        if (n % 2 == 0) {
            myPow(x * x, n / 2)
        } else {
            x * myPow(x * x, n / 2)
        }
    }

    def main(args: Array[String]): Unit = {
        val x: Double = 2
        val n: Int = -2147483648
        println(Int.MinValue)
        println(Int.MaxValue)
        val result = myPow(x, n)
        println(result)
        println(math.pow(x, n.toDouble))
    }


}
