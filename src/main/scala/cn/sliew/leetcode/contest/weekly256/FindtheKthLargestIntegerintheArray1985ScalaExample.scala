package cn.sliew.leetcode.contest.weekly256

import scala.collection.mutable

/**
  * 1985. Find the Kth Largest Integer in the Array medium
  */
object FindtheKthLargestIntegerintheArray1985ScalaExample {

    def kthLargestNumber(nums: Array[String], k: Int): String = {
        val priority = new mutable.PriorityQueue[BigInt]()
        for (num <- nums) {
            priority.enqueue(BigInt(num))
        }
        for (i <- 0 until k - 1) {
            priority.dequeue()
        }
        priority.dequeue().toString
    }

    def main(args: Array[String]): Unit = {
        val nums = Array("623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585")
        val k = 11
        val result = kthLargestNumber(nums, k)
        println(result)
    }
}
