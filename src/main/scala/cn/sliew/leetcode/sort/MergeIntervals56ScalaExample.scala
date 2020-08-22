package cn.sliew.leetcode.sort

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

/**
  * 56. Merge Intervals medium
  * tags: Array, Sort
  */
object MergeIntervals56ScalaExample {

    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        if (intervals == null || intervals.length <= 1) {
            return intervals
        }
        val sorted = intervals.sortBy(_(0)) // 按照子数组首个元素排序
        val result = new ArrayBuffer[Array[Int]]()
        var left = sorted(0)(0)
        var right = sorted(0)(1)
        for (i <- 1 until sorted.length) {
            val array = sorted(i)
            if (right < array(0)) {           // 无交集
                result += Array(left, right)
                left = array(0)
                right = array(1)
            } else if (right < array(1)) {    // 有交集
                right = array(1)
            }
                                              // 包含关系 noop
        }
        result += Array(left, right)
        result.toArray
    }

    def main(args: Array[String]): Unit = {
        val intervals: Array[Array[Int]] = Array(Array(1, 4), Array(2, 3))
        val result = merge(intervals)
        result.foreach(array => println(array.mkString("[", ",", "]")))
    }
}
