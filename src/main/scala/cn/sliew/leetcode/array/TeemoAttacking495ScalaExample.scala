package cn.sliew.leetcode.array

import scala.collection.mutable.ListBuffer

/**
  * 495.Teemo Attacking medium
  */
object TeemoAttacking495ScalaExample {

  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    val n: Int = timeSeries.length
    val tempList: ListBuffer[(Int, Int)] = new ListBuffer()
    for (i <- 0 until n){
      tempList += Tuple2.apply(timeSeries(i), timeSeries(i) + duration)
    }
    return mergeIntervals(tempList.toList)
  }

  private def mergeIntervals(intervals: List[(Int, Int)]): Int = {
    var result: Int = 0
    var left: Int = 0
    var right: Int = 0
    for ((i, j) <- intervals){
      if (i > right){
        if (right != left){
          result += right - left
        }
        left = i
        right = j
      } else {
        if (j > right){
          right = j
        } else {

        }
      }
    }
    result += right - left
    return result
  }

  def main(args: Array[String]): Unit = {
    val timeSeries: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val duration: Int = 1
    val result = findPoisonedDuration(timeSeries, duration)
    println(result)
  }
}
