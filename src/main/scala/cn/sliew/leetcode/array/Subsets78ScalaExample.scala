package cn.sliew.leetcode.array

import scala.collection.mutable.ListBuffer

/**
  * 78. Subsets medium
  */
object Subsets78ScalaExample {

  def subsets(nums: Array[Int]): List[List[Int]] = {
    val sorted = nums.sorted
    val result = new ListBuffer[List[Int]]()
    val n = nums.length
    val count = 1 << n
    for (i <- 0 until count){
      val item = new ListBuffer[Int]()
      for (j <- 0 until n){
        if ((i & (1 << j)) != 0){
          item += sorted(j)
        }
      }
      result += item.toList
    }
    return result.toList
  }


  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3)
    val list = subsets(nums)
    println(list.mkString(", "))

    println(1 & (1 << 0))
  }
}
