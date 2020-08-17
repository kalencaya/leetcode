package cn.sliew.leetcode.binarysearch

/**
  * 29. Divide Two Integers medium
  */
object DivideTwoIntegers29ScalaExample {

    def divide(dividend: Int, divisor: Int): Int = {
        var sign = 1
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1
        }
        val absDividend: Long = math.abs(dividend.toLong)
        val absDivisor: Long = math.abs(divisor.toLong)
        if (absDivisor == 0) {
            return Int.MaxValue
        }
        if (absDividend == 0 || absDividend < absDivisor) {
            return 0
        }

        val lans: Long = ldivide(absDividend, absDivisor)
        var answer: Int = 0
        if (lans > Int.MaxValue) {
            if (sign == 1) {
                answer = Int.MaxValue
            } else {
                answer = Int.MinValue
            }
        } else {
            answer = sign * lans.toInt
        }
        answer
    }

    private def ldivide(ldividend: Long, ldivisor: Long): Long = {
        //递归终止条件
        if (ldividend < ldivisor) {
            return 0L
        }

        // 找出符合条件的multiple，保证multiple * ldivisor <= ldividend
        //这里的sum + sum，multiple + multiple，其实相当于每次multiple * ldivisior * 2在递增
        //整体的递进按照1, 2, 4, 8, 16...按照二叉搜索的方式在递增
        var sum: Long = ldivisor
        var multiple: Long = 1L
        while ((sum + sum) <= ldividend) {
            sum += sum
            multiple += multiple
        }

        //因为sum < ldividend，sum + sum > ldividend，这里需要继续计算
        //ldividend - sum和ldivisor的差值
        multiple + ldivide(ldividend - sum, ldivisor)
    }

    def main(args: Array[String]): Unit = {
        val dividend = -2147483648
        val divisor = -1
        val result = divide(dividend, divisor)
        println(result)
    }
}
