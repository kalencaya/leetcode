package cn.sliew.leetcode.contest.weekly259

import scala.collection.mutable

/**
  * 5877. Detect Squares medium
  */
object DetectSquares5877ScalaExample {

    private val map = new mutable.HashMap[(Int, Int), Int]()

    private val vertical = new mutable.HashMap[Int, mutable.HashSet[(Int, Int)]]()
    private val horizontal = new mutable.HashMap[Int, mutable.HashSet[(Int, Int)]]()

    def add(point: Array[Int]) {
        val tuple = (point(0), point(1))
        if (map.contains(tuple)) {
            val count = map.get(tuple).get
            map.put(tuple, count + 1)
        } else {
            map.put(tuple, 1)
        }
        val x = point(0)
        val y = point(1)
        if (vertical.contains(x)) {
            val points = vertical.get(x).get
            points.add(tuple)
        } else {
            val points = new mutable.HashSet[(Int, Int)]()
            points.add(tuple)
            vertical.put(x, points)
        }

        if (horizontal.contains(y)) {
            val points = horizontal.get(y).get
            points.add(tuple)
        } else {
            val points = new mutable.HashSet[(Int, Int)]()
            points.add(tuple)
            horizontal.put(y, points)
        }
    }

    def count(point: Array[Int]): Int = {
        val x = point(0)
        val y = point(1)
        if (vertical.contains(x) == false) {
            return 0
        }
        if (horizontal.contains(y) == false) {
            return 0
        }
        val xPoints = vertical.get(x).get
        val yPoints = horizontal.get(y).get
        var count = 0
        for (xPoint <- xPoints; yPoint <- yPoints) {
            val tuple = (yPoint._1, xPoint._2)
            if (map.contains(tuple)) {
                val first = map.get(xPoint).get
                val second = map.get(yPoint).get
                val third = map.get(tuple).get
                count += first * second * third
            }
        }
        count
    }

    def main(args: Array[String]): Unit = {
        add(Array(5, 10))
        add(Array(10, 5))
        add(Array(10, 10))
        val result1 = count(Array(5, 5))
        println(result1)

        add(Array(3, 0))
        add(Array(8, 0))
        add(Array(8, 5))
        val result2 = count(Array(3, 5))
        println(result2)

        add(Array(9, 0))
        add(Array(9, 8))
        add(Array(1, 8))
        val result3 = count(Array(1, 0))
        println(result3)

        add(Array(0, 0))
        add(Array(8, 0))
        add(Array(8, 8))
        val result4 = count(Array(0, 8))
        println(result4)
    }


}
