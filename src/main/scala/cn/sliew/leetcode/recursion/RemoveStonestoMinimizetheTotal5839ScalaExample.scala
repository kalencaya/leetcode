package cn.sliew.leetcode.recursion

import scala.collection.mutable

/**
  * 5839. Remove Stones to Minimize the Total weekly contest 253
  */
object RemoveStonestoMinimizetheTotal5839ScalaExample {

    def minStoneSum(piles: Array[Int], k: Int): Int = {
        val topK = new mutable.PriorityQueue[Int]()
        for (i <- 0 until piles.length) {
            topK += piles(i)
        }

        for (i <- 0 until k) {
            val max = topK.dequeue()
            topK += math.ceil(max / 2.0).toInt
        }
        topK.sum
    }

    def main(args: Array[String]): Unit = {
        val piles = Array(4, 3, 6, 7)
        val k = 3
        val result = minStoneSum(piles, k)
        println(result)
    }

}
