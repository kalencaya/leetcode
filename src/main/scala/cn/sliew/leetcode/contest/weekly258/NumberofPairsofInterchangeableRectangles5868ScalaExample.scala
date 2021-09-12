package cn.sliew.leetcode.contest.weekly258

import scala.collection.mutable

/**
  * 5868. Number of Pairs of Interchangeable Rectangles medium
  */
object NumberofPairsofInterchangeableRectangles5868ScalaExample {

    def interchangeableRectangles(rectangles: Array[Array[Int]]): Long = {
        var count = 0L
        val map = new mutable.HashMap[BigDecimal, Int]()
        for (rectangle <- rectangles) {
            val ratio = BigDecimal(rectangle(0)) / BigDecimal(rectangle(1))
            if (map.contains(ratio)) {
                map.put(ratio, map.get(ratio).get + 1)
            } else {
                map.put(ratio, 1)
            }
        }

        for (entry <- map; if entry._2 > 1) {
            count += entry._2 * (entry._2 - 1) / 2
        }

        count
    }

    def main(args: Array[String]): Unit = {
        val rectangles = Array(
            Array(4, 8),
            Array(3, 6),
            Array(10, 20),
            Array(15, 30),
        )

        val result = interchangeableRectangles(rectangles)
        println(result)
    }
}
