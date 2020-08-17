package cn.sliew.leetcode.binarysearch

/**
  * 69. Sqrt(x) easy
  */
object Sqrtx69ScalaExample {

    def mySqrt(x: Int): Int = {
        if (x == 0) {
            return 0
        }
        var num: Long = 1L
        var temp : Long = num * num
        val lx: Long = x.toLong
        while (temp <= lx) {
            num += num
            temp = num * num
        }
        num = num / 2L
        temp = num * num
        while (temp <= lx) {
            num += 1L
            temp = num * num
        }
        num.toInt - 1
    }

    def mySqrt2(x: Int): Int = {
        if (x == 0) {
            return 0
        }

        var left: Long = 1L
        var right = x.toLong
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid * mid > x) {
                right = mid - 1
            } else {
                if ((mid + 1) * (mid + 1) > x) {
                    return mid.toInt
                }
                left = mid + 1
            }
        }
        1
    }

    def main(args: Array[String]) = {
        val x = 2147395599
        val result = mySqrt2(x)
        println(result)
        println(math.sqrt(x))
    }
}
