package cn.sliew.leetcode.contest.weekly254

import scala.collection.mutable

object MinimumNonZeroProductoftheArrayElements5844ScalaExample {

    def minNonZeroProduct(p: Int): Int = {
        if (p == 1) {
            return 1
        }
        if (p == 2) {
            return 6
        }
        val max = math.pow(2, p) - 1
        val nums = (1 to max.toInt) toBuffer

        var left = 1
        var right = nums.length - 1 - 1
        while (left < right) {
            if (swap(left, right, nums)) {
                left += 1
                right -= 1
            } else {
                right -= 1
            }
        }

        val module = math.pow(10, 9) + 7
        nums.product % module.toInt
    }

    private def swap(left: Int, right: Int, nums: mutable.Buffer[Int]): Boolean = {
        var minleftNum = nums(left)
        var minrightNum = nums(right)
        val length = math.max(minleftNum.toBinaryString.length, minrightNum.toBinaryString.length)
        var min = minleftNum * minrightNum
        var changed = false
        for (i <- 0 until length) {
            var leftNum = nums(left)
            var rightNum = nums(right)

            val leftChar = (leftNum >> i) & 1
            val rightChar = (rightNum >> i) & 1
            if (leftChar != rightChar) {
                leftNum ^= (leftNum & (1 << i)) ^ (rightChar << i)
                rightNum ^= (rightNum & (1 << i)) ^ (leftChar << i)

                if (leftNum != 0 && rightNum != 0 && leftNum * rightNum < min) {
                    changed = true
                    min = leftNum * rightNum
                    minleftNum = leftNum
                    minrightNum = rightNum
                }
            }
        }

        if (changed) {
            nums.update(left, minleftNum)
            nums.update(right, minrightNum)
        }
        changed
    }

    def main(args: Array[String]): Unit = {
        val p = 3
        val result = minNonZeroProduct(p)
        println(result)
    }

}
