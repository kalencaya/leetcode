package cn.sliew.leetcode.recursion

/**
  * 1922. Count Good Numbers medium
  */
object CountGoodNumbers1922ScalaExample {

    private val mod = BigInt(math.pow(10, 9).toInt + 7)

    def countGoodNumbers(n: Long): Int = {
        recurse(n) % mod toInt
    }

    private def recurse(n: Long): BigInt = {
        if (n == 1) {
            return 5
        }
        val previous = recurse(n - 1)
        if (n % 2 == 0) {
            previous * 4
        } else {
            previous * 5
        }
    }

    def main(args: Array[String]): Unit = {
        val n = 50
        val result = countGoodNumbers(n)
        println(result)
    }

}
