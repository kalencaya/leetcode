package cn.sliew.leetcode.recursion

import scala.collection.mutable

/**
  * 1545. Find Kth Bit in Nth Binary String medium
  */
object FindKthBitinNthBinaryString1545ScalaExample {

    private val cache = new mutable.HashMap[Int, Int]()

    def findKthBit(n: Int, k: Int): Char = {
        if (n == 1) {
            return '0'
        }
        val length = computeLengthByLevel(n)
        val previousLength = length / 2
        if (k <= previousLength) {
            findKthBit(n - 1, k)
        } else if (k == previousLength + 1) {
            '1'
        } else {
            val left = length - k + 1
            val char = findKthBit(n - 1, left)
            if (char == '0') '1' else '0'
        }
    }

    private def computeLengthByLevel(n: Int): Int = {
        if (cache.contains(n)) {
            return cache(n)
        }

        if (n == 1) {
            cache += 1 -> 1
            return 1
        }

        val length = computeLengthByLevel(n - 1)
        cache += n -> (2 * length + 1)
        2 * length + 1
    }

    def main(args: Array[String]): Unit = {
        val n = 4
        val k = 12
        val result = findKthBit(n, k)
        println(result)
    }
}
