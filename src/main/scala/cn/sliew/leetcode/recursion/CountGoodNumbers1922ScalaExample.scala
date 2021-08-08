package cn.sliew.leetcode.recursion

/**
  * 1922. Count Good Numbers medium
  */
object CountGoodNumbers1922ScalaExample {

    private val mod = BigInt(math.pow(10, 9).toInt + 7)

    def countGoodNumbers(n: Long): Int = {
        if (n == 1) {
            return 5
        }
        var result = BigInt(5)
        for (i <- 1L until n) {
            if (i % 2 == 0) {
                result = result * 4
            } else {
                result = result * 5
            }
        }
        result % mod toInt
    }

    def main(args: Array[String]): Unit = {
        val n = 50
        val result = countGoodNumbers(n)
        println(result)
    }

}
